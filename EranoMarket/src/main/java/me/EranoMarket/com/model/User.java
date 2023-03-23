package me.EranoMarket.com.model;

import java.util.Objects;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	//hashcodela
	private String password;
	
	private String email;
	
	private String country;
	
	private String nationalNumber;
	
	//private Role role = Role.CUSTOMER;

	//hashPassword
	public static String hashPassword(String plainTextPassword) {
	    String salt = BCrypt.gensalt();
	    return BCrypt.hashpw(plainTextPassword, salt);
	}
	public User() {
		
	}
	public User(String username, String password, String email, String country, String nationalNumber) {
		this.username = username;
		this.password = hashPassword(password);
		this.email = email;
		this.country = country;
		this.nationalNumber = nationalNumber;
		//this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long i) {
		this.id = i;
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

//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", country=" + country + ", nationalNumber=" + nationalNumber ;
				//+ ", role=" + role + "]";
	}
	@Override
	public int hashCode() {
		return id!=null ? id.hashCode() :0;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass()!=obj.getClass()) return false;

		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
	

	
	
	
}
