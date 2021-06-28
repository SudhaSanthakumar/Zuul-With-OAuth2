package com.demo.util.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.PersistenceConstructor;


@Entity
@Table(name = "utility")
public class Utility {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "utility_id")
	private int utilityId;

	@Column(name = "utility_name")
	private String utilityName;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "utility_provider", joinColumns = { @JoinColumn(name = "utility_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private Set<User> utilityProviders;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "utility_consumer", joinColumns = { @JoinColumn(name = "utility_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private Set<User> utilityConsumers;

	public Utility() {
		super();
	}

	public Utility(int utilityId, String utilityName) {

		this.utilityId = utilityId;
		this.utilityName = utilityName;

	}

	@PersistenceConstructor
	public Utility(String utilityName) {

		this.utilityName = utilityName;

	}

	public Utility(int utilityId, String utilityName, Set<User> utilityProviders, Set<User> utilityConsumers) {
		super();
		this.utilityId = utilityId;
		this.utilityName = utilityName;
		this.utilityProviders = utilityProviders;
		this.utilityConsumers = utilityConsumers;
	}

	public int getUtilityId() {
		return utilityId;
	}

	public void setUtilityId(int utilityId) {
		this.utilityId = utilityId;
	}

	public String getUtilityName() {
		return utilityName;
	}

	public void setUtilityName(String utilityName) {
		this.utilityName = utilityName;
	}

	public Set<User> getUtilityProviders() {
		return utilityProviders;
	}

	public void setUtilityProviders(Set<User> utilityProviders) {
		this.utilityProviders = utilityProviders;
	}

	public Set<User> getUtilityConsumers() {
		return utilityConsumers;
	}

	public void setUtilityConsumers(Set<User> utilityConsumers) {
		this.utilityConsumers = utilityConsumers;
	}

}
