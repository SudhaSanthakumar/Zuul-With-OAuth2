package com.auth.server.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.auth.server.service.UserService;
import com.auth.server.model.MyUserDetails;
import com.auth.server.model.User;


@RestController
@RequestMapping("/v1")
public class UserResourceController {

	
	@Autowired
	private UserService userService;
	
	Logger log=LoggerFactory.getLogger(UserResourceController.class);
	
	
	@PostMapping(value="/users")
	public ResponseEntity<String> saveuser(@RequestBody User user ) {
		
		userService.save(user);
		return new ResponseEntity<String>(HttpStatus.CREATED);
		
	}
	@PutMapping(value="/users/{userId}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateuser(@RequestBody User user ,@PathVariable ("userId") int userId) {
		
		User s = userService.update(userId,user).get();
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<User>(s,headers,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping(value="/users/{userId}")
	public ResponseEntity<User> deleteuser(@PathVariable ("userId") int userId) {
		
		userService.delete(userId);
		
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping(value="/users", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllusers() {
		
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.FOUND);
		
	}
	
	@GetMapping(value="/users/{userId}")
	public User getuserById(@PathVariable ("userId") int userId) {
		
		log.info("inside get mapping getbyid "+ SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		User user=userService.getUserById(userId).get();
			
//		if(user==null) {
//			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<User>(user,HttpStatus.OK);
		
		if(user==null) {
			return null;
		}
		return user;
	}
	
	@GetMapping(value="/users/search/me",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getuserByIds(Authentication auth) {
		
		log.info("inside me "+SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equals("anonymousUser"))
			return null;
		MyUserDetails userD=(MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		log.info("inside me " +auth.getName());
		User user=userService.getUserByUserName( userD.getUsername());
			
		if(user==null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping(value="/users/search/{userName}")
	public ResponseEntity<User> getuserByUserName(@PathVariable ("userName") String userName) {
		
		log.info("inside getbyusername");
		User user=userService.getUserByUserName(userName);
		
		
		if(user==null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
	
	
}
