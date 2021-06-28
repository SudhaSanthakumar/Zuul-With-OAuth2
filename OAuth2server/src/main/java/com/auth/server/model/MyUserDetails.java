package com.auth.server.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.auth.server.model.User;

public class MyUserDetails implements UserDetails {
	
	
	private static final long serialVersionUID = 1L;

	private User user;
	
	public MyUserDetails(User user) {
		super();
		this.user=user;
		
//		System.out.println("user in userdetails impl "+user.getUserName()+"  "+user.getPassword());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		List<GrantedAuthority> ga=new ArrayList<GrantedAuthority>();
					
		
		ga.add(new SimpleGrantedAuthority("ROLE_"+this.user.getRoles().getRoleName().toUpperCase()));
		this.user.getRoles().getPermissions().forEach(permission->{
				ga.add(new SimpleGrantedAuthority(permission.getPermissionName().toUpperCase()));
			});
	
//		ga.forEach(	a->System.out.println(a.getAuthority()));
		
		return ga;
	}

	@Override
	public String getPassword() {
		
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return this.user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	 public User getUserDetails() {
	        return user;
	    }

}
