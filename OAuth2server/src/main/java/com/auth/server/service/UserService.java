package com.auth.server.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.auth.server.iservice.IUserService;
import com.auth.server.repository.UserRepository;
import com.auth.server.model.User;



@Service
public class UserService implements IUserService{

	@Autowired
	UserRepository userRepo;
	
	
	Logger log=LoggerFactory.getLogger(UserService.class);

	@Override
	public void save(User user) {
			log.info("saving user");
			userRepo.save(user);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Optional<User> update(int userId, User user) {
		
		
			return userRepo.findById(userId);
				
	}
	
	@Override
	public void delete(int userId) {
		userRepo.deleteById(userId);
	}

	@Override
	public List<User> getUsers() {
		
		List<User> users=userRepo.findAll();
		return users;
	}

	@Override
	public Optional<User> getUserById(int userId) {
		
		
			return userRepo.findById(userId);
	
	}

	
	@Override
	public User getUserByUserName(String userName) {
		
		return userRepo.findByUserName(userName);
	}

	
	

}
