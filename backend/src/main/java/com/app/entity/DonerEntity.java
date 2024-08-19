package com.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class DonerEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String address;
private String username;
private String password;
private String confirmPassword;
private String email;
private String phoneNumber;
private String role;

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public DonerEntity() {
	super();
	// TODO Auto-generated constructor stub
}
public DonerEntity(Long id, String name, String address, String username, String password, String confirmPassword,
		String email, String phoneNumber) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.username = username;
	this.password = password;
	this.confirmPassword = confirmPassword;
	this.email = email;
	this.phoneNumber = phoneNumber;
}

public DonerEntity(String name, String address, String username, String password, String confirmPassword, String email,
		String phoneNumber) {
	super();
	this.name = name;
	this.address = address;
	this.username = username;
	this.password = password;
	this.confirmPassword = confirmPassword;
	this.email = email;
	this.phoneNumber = phoneNumber;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
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
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
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

}

