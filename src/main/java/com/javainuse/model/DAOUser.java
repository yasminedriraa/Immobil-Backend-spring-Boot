package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class DAOUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String adresse;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private String email;

    @Column
    @Nullable
    private String entreprise;

    @Column
    @Nullable
    private String emailEntreprise;

    @Column
    @Nullable
    private String telEntreprise;

    @Column
    @Nullable
    private String matricule;

    @Column
    @Nullable
    private String adresseEntreprise;

    @Column
    @Nullable
    private UserDTO.Pack pack;

    @Column
    @Nullable
    private String phoneNumber;

    @Column
    @Nullable
    private String type;

    @Column
    @Nullable
    private String urlprofilepicture;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Nullable
    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(@Nullable String entreprise) {
        this.entreprise = entreprise;
    }

    @Nullable
    public UserDTO.Pack getPack() {
        return pack;
    }

    public void setPack(@Nullable UserDTO.Pack pack) {
        this.pack = pack;
    }

    @Nullable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Nullable String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    public String getType() {
        return type;
    }

    public void setType(@Nullable String type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Nullable
    public String getEmailEntreprise() {
        return emailEntreprise;
    }

    public void setEmailEntreprise(@Nullable String emailEntreprise) {
        this.emailEntreprise = emailEntreprise;
    }

    @Nullable
    public String getTelEntreprise() {
        return telEntreprise;
    }

    public void setTelEntreprise(@Nullable String telEntreprise) {
        this.telEntreprise = telEntreprise;
    }

    @Nullable
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(@Nullable String matricule) {
        this.matricule = matricule;
    }

    @Nullable
    public String getAdresseEntreprise() {
        return adresseEntreprise;
    }

    public void setAdresseEntreprise(@Nullable String adresseEntreprise) {
        this.adresseEntreprise = adresseEntreprise;
    }

    @Nullable
    public String getUrlprofilepicture() {
        return urlprofilepicture;
    }

    public void setUrlprofilepicture(@Nullable String urlprofilepicture) {
        this.urlprofilepicture = urlprofilepicture;
    }
}
