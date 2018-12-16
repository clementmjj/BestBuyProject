package com.niit.bestbuy.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table
public class User 
{
	@Id
	@NotBlank
	@Size(min=8, max=12, message="Username must be between 8 to 12 characters")
	private String username;
	
	//@NotBlank
	//@Size(min=8, max=12)
	private String password;
	
	@Transient
	//@NotBlank
	//@Size(min=8, max=12)
	private String confirmPassword;
	
	//@NotBlank
	//@Size(min=1, max=20, message="Full name must be between 1 to 20 characters")
	private String userFullName;
	
	//@NotBlank
	//@Size(min=1, max=200, message="Address must be between 8 to 200 characters")
	private String userAddress;
	
	//@NotBlank
	//@Pattern(regexp="('ROLE_ADMIN'|'ROLE_USER')")
	private String role;
	
	//@NotBlank
	//@Email
	private String email;
	
	//@NotBlank
	//@Pattern(regexp="([0-9]{10})")
	private String mobileNo;
	
	//@NotBlank
	private boolean enabled;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
