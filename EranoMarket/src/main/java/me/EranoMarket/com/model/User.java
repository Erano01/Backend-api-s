package me.EranoMarket.com.model;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	private int id;
	
	@Column(name="username")
	private String username;

	//hashcodela
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="country")
	private String country;
	
	@Column(name="national_number")
	private String nationalNumber;//t.c kimlik vb
	
	//profil fotoğrafı ekleyebilsinler
	
	@Column(name = "role")
	//@Convert(converter = RoleConverter.class)
	@Enumerated(EnumType.STRING)
	private Role role;

	//hashPassword
	public static String hashPassword(String plainTextPassword) {
	    String salt = BCrypt.gensalt();
	    return BCrypt.hashpw(plainTextPassword, salt);
	}
	
	
	public User() {
		
	}
	
	
	public User(String username, String password, String email, String country, String nationalNumber, Role role) {
		this.username = username;
		this.password = hashPassword(password);
		this.email = email;
		this.country = country;
		this.nationalNumber = nationalNumber;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		this.password = hashPassword(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNationalNumber() {
		return nationalNumber;
	}

	public void setNationalNumber(String nationalNumber) {
		this.nationalNumber = nationalNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	

	
	
	
}
