package com.javainuse.service;

import java.time.LocalDate;
import java.util.*;

import com.javainuse.model.PasswordResetToken;
import com.javainuse.model.Role;
import com.javainuse.repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javainuse.repository.UserDao;
import com.javainuse.model.DAOUser;
import com.javainuse.model.UserDTO;

import javax.mail.MessagingException;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private static final String BASE_APP_URL = "http://localhost:4200/api/v1/updatePassword";
    @Autowired
    private UserDao userDao;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private PasswordResetTokenRepository passwordTokenRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DAOUser user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(DAOUser user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public List<DAOUser> findAll() {
        List<DAOUser> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public DAOUser forgotPassword(String email) {
        return userDao.findByEmail(email);
    }

    public DAOUser save(UserDTO user) throws Exception {
        Set<Role> roles = new HashSet<Role>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        if (user.getRole().getName().equals("CLIENT")) {
            DAOUser regularUser = new DAOUser();
            regularUser.setUsername(user.getEmail());
            regularUser.setPassword(bcryptEncoder.encode(user.getPassword()));
            regularUser.setFirstName(user.getFirstName());
            regularUser.setLastName(user.getLastName());
            regularUser.setEmail(user.getEmail());
            regularUser.setUrlprofilepicture(user.getUrlprofilepicture());
            roles.add(user.getRole());
            regularUser.setRoles(roles);
            DAOUser savedUser = userDao.save(regularUser);
            emailService.sendSimpleMessage(savedUser.getEmail(), "Bienvenue a Immobilier", "text", savedUser.getId());
            return savedUser;
        }
        if (user.getRole().getName().equals("PROMOTEUR")) {
            DAOUser promoteurUser = new DAOUser();
            promoteurUser.setUsername(user.getEmail());
            promoteurUser.setFirstName(user.getFirstName());
            promoteurUser.setLastName(user.getLastName());
            promoteurUser.setPassword(bcryptEncoder.encode(user.getPassword()));
            roles.add(user.getRole());
            promoteurUser.setRoles(roles);
            promoteurUser.setEmail(user.getEmail());
            promoteurUser.setEntreprise(user.getEntreprise());
            promoteurUser.setAdresseEntreprise(user.getAdresseEntreprise());
            promoteurUser.setEmailEntreprise(user.getEmailEntreprise());
            promoteurUser.setTelEntreprise(user.getTelEntreprise());
            promoteurUser.setPack(user.getPack());
            promoteurUser.setPhoneNumber(user.getPhoneNumber());
            promoteurUser.setType(user.getType());
            promoteurUser.setAdresse(user.getAdresse());
            promoteurUser.setUrlprofilepicture(user.getUrlprofilepicture());
            DAOUser savedUser = userDao.save(promoteurUser);
            return savedUser;
        }
        return null;
    }

    public boolean isPasswordMatching(UserDTO userDTO) {
        return userDTO.getPassword().equals(userDTO.getRepeatPassword());
    }

    public DAOUser activateUserAccount(Long id) {
        DAOUser userFromDb = userDao.findDAOUserById(id);
        return userDao.save(userFromDb);
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("immobilpfe@gmail.com");
        mailSender.setPassword("immobil1234");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }

    public DAOUser findUserByUsername(String username) {
        return userDao.findByUsername(username);
    }
    public DAOUser findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public DAOUser updateUserProfile(DAOUser profile) {
        DAOUser user = userDao.findDAOUserById(profile.getId());
        user.setAdresse(profile.getAdresse());
        user.setLastName(profile.getLastName());
        user.setFirstName(profile.getFirstName());
        user.setTelEntreprise(profile.getTelEntreprise());
        user.setEmail(profile.getEmail());
        user.setAdresseEntreprise(profile.getAdresseEntreprise());
        user.setPassword(profile.getPassword());
        user.setType(profile.getType());
        return user;
    }

    public DAOUser getUserById(Long id) {
        return userDao.findDAOUserById(id);
    }

    public DAOUser getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public void createPasswordResetTokenForUser(DAOUser user, String token) {
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordTokenRepository.save(myToken);
    }

    /**
     *
     * @param user_id
     * @param token
     * @return
     */
    public String constructResetTokenEmail(Long user_id, String token) {
        return new StringBuilder().append(JwtUserDetailsService.BASE_APP_URL).append("/").append(user_id).append("/").append(token).toString();
    }

    /**
     *
     * @param emailResetString
     * @param user
     */
    public void sendResetPasswordEmail(String emailResetString, DAOUser user) {
        try {
            emailService.sendPasswordResetEmail(user.getEmail(), "Password Rest Email", emailResetString, user.getId());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param token
     * @return
     */
    public PasswordResetToken getPasswordResetTokenByToken(String token) {
        return passwordTokenRepository.findPasswordResetTokenByToken(token);
    }

    /**
     *
     * @param id
     */
    public void deletePasswordResetToken(Long id) {
        passwordTokenRepository.deleteById(id);
    }

    /**
     *
     * @param passwod
     * @return
     */
    public String encodePassword(String passwod) {
        return bcryptEncoder.encode(passwod);
    }
}
