package com.auth.server.model;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name="role")
@Entity
public class Role implements  Serializable{
	
	private static final long serialVersionUID = 1567637283572978119L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "role_permission",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")}
    )
	private Set<Permission> permissions;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="role_Id")
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
