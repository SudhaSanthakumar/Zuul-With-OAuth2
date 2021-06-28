	package com.demo.user.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name="user")
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 983648238746032841L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="email")
	private String emailId;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Role role;
	
	@ManyToMany(mappedBy = "utilityConsumers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Utility> consumedUtilitites;
	
	@ManyToMany(mappedBy = "utilityProviders", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Utility> providedUtilitites;
	
	
	@Column(name="contact_number")
	private Integer contactNumber;
	
	@Column(name="rating")
	private Integer rating;
	
	@Column(name="dor")
	private Date dateOfRegistration;

	public User() {
		super();
	}

		
	public User(int userId, String userName, String userType, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password=password;
		this.dateOfRegistration = Calendar.getInstance().getTime();
		this.userType = userType;
		
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


	public Set<Utility> getConsumedUtilitites() {
		return consumedUtilitites;
	}


	public void setConsumedUtilitites(Set<Utility> consumedUtilitites) {
		this.consumedUtilitites = consumedUtilitites;
	}


	public Set<Utility> getProvidedUtilitites() {
		return providedUtilitites;
	}


	public void setProvidedUtilitites(Set<Utility> providedUtilitites) {
		this.providedUtilitites = providedUtilitites;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Role getRole() {
		return role;
	}


	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
	
}
