package com.example.ZuulClient.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;



public class User implements Serializable {

//	private static final long serialVersionUID = 983648238746032841L;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int userId;
	
	private String userName;
	
	
	private String password;
	
	private String userType;
	
	
	private String emailId;
	
	
	private Role role;
	
//	@ManyToMany(mappedBy = "consumers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	private Set<Utility> utilitites;
	
	
	
	private Integer contactNumber;
	
	
	private Integer rating;
	
	
	private Date dateOfRegistration;

	public User() {
		super();
	}

		
	public User(int userId, String userName, String userType, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password=password;
		this.dateOfRegistration = Calendar.getInstance().getTime();
		
	}
	
	public User(String userName, String userType, String password) {
		
		this.userName = userName;
		this.password=password;
		this.dateOfRegistration = Calendar.getInstance().getTime();
		this.contactNumber =54323;
		this.rating = 0;
	}

	public User (User user) {
		super();
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.password=user.getPassword();
		this.userType = user.getUserType();
		this.emailId = user.getEmailId();
		this.contactNumber = user.getContactNumber();
		this.rating = user.getRating();
		this.dateOfRegistration = user.getDateOfRegistration();
		this.role=user.getRoles();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
		
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getRoles() {
		return role;
	}

	public void setRole(Role roles) {
		this.role = roles;
	}
	
}
