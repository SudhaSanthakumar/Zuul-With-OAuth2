package com.auth.server.iservice;

import java.util.List;
import java.util.Optional;

import com.auth.server.model.User;



public interface IUserService {

	public void save(User user);
	
	public Optional<User> update(int userId,User user);
	
	public void delete(int userId);
	
	public List<User> getUsers();
	
	public Optional<User> getUserById(int userId);
	
	public User getUserByUserName(String userName);
	
	
}
