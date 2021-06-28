package com.example.ZuulClient.model;

import java.io.Serializable;
import java.util.Set;



public class Role implements  Serializable{
	
	private static final long serialVersionUID = 1567637283572978119L;

	
	private int roleId;
	
	
	private String roleName;
	
	
 
	private Set<Permission> permissions;
	
	
	private Set<User> users;


	public Role() {
		super();
	}
	
	
	public Role(int roleId, String roleName, Set<Permission> permissions) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.permissions = permissions;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
}
