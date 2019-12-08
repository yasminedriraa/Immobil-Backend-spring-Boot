package com.javainuse.controller;

import java.util.Objects;
import java.util.UUID;

import com.javainuse.model.*;
import com.javainuse.model.DTO.AuthResponseDTO;
import com.javainuse.model.DTO.PasswordResetBodyDto;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.javainuse.service.JwtUserDetailsService;


import com.javainuse.config.JwtTokenUtil;

import javax.xml.ws.Response;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    /**
     * authenticate user by username and password
     *
     * @param authenticationRequest
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        Authentication authentication = authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        Claims claims = jwtTokenUtil.getAllClaimsFromToken(token);
        DAOUser daoUser = userDetailsService.findUserByUsername(authenticationRequest.getEmail());
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setToken(token);
        authResponseDTO.setClaims(claims);
        authResponseDTO.setUser(daoUser);
        return ResponseEntity.ok(authResponseDTO);
    }

    /**
     * creates a user
     *
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    /**
     * return the password by email
     *
     * @param email
     * @return
     */
    @GetMapping("/forgot-password/{email}")
    public ResponseEntity<?> forgotPassword(@PathVariable("email") String email) {
        return ResponseEntity.ok(userDetailsService.forgotPassword(email));
    }

    /**
     * activate account with a givin id
     *
     * @param id
     * @return
     */
    @GetMapping("/activate-account/{id}")
    public ResponseEntity<?> activateAccount(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userDetailsService.activateUserAccount(id));
    }

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    private Authentication authenticate(String username, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    /**
     *
     * @param user_id
     * @return
     */
    @GetMapping("/user")
    public ResponseEntity<?> getUserById(@RequestParam("user_id") Long user_id) {
        return ResponseEntity.ok().body(userDetailsService.getUserById(user_id));
    }

    /**
     *
     * @param email
     * @return
     * @throws Exception
     */
    @PostMapping("/user/resetPassword")
    public ResponseEntity<?> resetPasswordEmail(@RequestParam("email") String email) throws Exception {
        DAOUser user = userDetailsService.getUserByEmail(email);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        String token = UUID.randomUUID().toString();
        userDetailsService.createPasswordResetTokenForUser(user, token);
        String passwordResetString = userDetailsService.constructResetTokenEmail(user.getId(), token);
        userDetailsService.sendResetPasswordEmail(passwordResetString, user);
        return ResponseEntity.ok().body("200");
    }

    /**
     *
     * @param id
     * @param token
     * @param passwordResetBodyDto
     * @return
     */
    @GetMapping("/api/v1/updatePassword/{userId}/{token}")
    public ResponseEntity<?> resetUserPassword(@PathVariable("userId") Long id, @PathVariable("token") String token, @RequestBody @Nullable PasswordResetBodyDto passwordResetBodyDto) {
       PasswordResetToken passwordResetTokenBody = userDetailsService.getPasswordResetTokenByToken(token);
        if (passwordResetTokenBody == null) {
            return null;
        }
        DAOUser user = passwordResetTokenBody.getUser();
        if (passwordResetBodyDto.getNewPassword().equals(passwordResetBodyDto.getNewPasswordConfirmation())) {
            user.setPassword(userDetailsService.encodePassword(passwordResetBodyDto.getNewPassword()));
            userDetailsService.updateUserProfile(user);
            userDetailsService.deletePasswordResetToken(passwordResetTokenBody.getId());
            return ResponseEntity.ok().body(user);
        }
        return null;
    }
}
