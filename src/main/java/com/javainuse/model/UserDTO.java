package com.javainuse.model;

import java.util.Set;

public class UserDTO {
	private String username;
	private String firstName;
	private String lastName;
	private String adresse;
	private String password;
	private String repeatPassword;
	private String email;
	private String phoneNumber;
	private String entreprise;
	private String telEntreprise;
	private String emailEntreprise;
	private String matricule;
	private String adresseEntreprise;
	private Pack pack;
	private String type;
	private Role role;
	private String urlprofilepicture;

	public UserDTO() {

	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public enum Pack {
		BASIC,
		SILVER,
		GOLD
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

	public String getTelEntreprise() {
		return telEntreprise;
	}

	public void setTelEntreprise(String telEntreprise) {
		this.telEntreprise = telEntreprise;
	}

	public String getEmailEntreprise() {
		return emailEntreprise;
	}

	public void setEmailEntreprise(String emailEntreprise) {
		this.emailEntreprise = emailEntreprise;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getAdresseEntreprise() {
		return adresseEntreprise;
	}

	public void setAdresseEntreprise(String adresseEntreprise) {
		this.adresseEntreprise = adresseEntreprise;
	}

	public String getUrlprofilepicture() {
		return urlprofilepicture;
	}

	public void setUrlprofilepicture(String urlprofilepicture) {
		this.urlprofilepicture = urlprofilepicture;
	}
}
