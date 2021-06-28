package com.example.ZuulClient.model;

import java.io.Serializable;
import java.util.Set;




public class Permission implements  Serializable{
	
	
	private static final long serialVersionUID = 8087275050725156377L;


	
	private int permissionId;
	
	
	private String permissionName;
	
	
	private Set<Role> roles;

	public Permission() {
		super();
	}

	public Permission(int permissionId, String permissionName) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
}
