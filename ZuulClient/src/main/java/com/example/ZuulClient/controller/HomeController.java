package com.example.ZuulClient.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.example.ZuulClient.model.User;
import com.example.ZuulClient.model.Utility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@SessionAttributes({"user","access_token"})

public class HomeController {
	
	
	@Value("${security.clientId}")
	private String clientId;
	
	@Value("${security.clientSecret}")
	private String clientSecret;
	
	@Value("${security.authorizationUri}")
	private String authorizationUri;
	
	@Value("${security.tokenUri}")
	private String tokenUri;
	
	@Value("${security.userInfoUri}")
	private String userInfoUri;
	
	@Value("${security.callbackUri}")
	private String callbackUri;
	
	@Autowired
	RestTemplate restTemplate;


	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("/")
	public String getIndex1(Model model, HttpSession session){
		
		
			model.addAttribute("user",SecurityContextHolder.getContext().getAuthentication().getName());
			model.addAttribute("role",SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		
		return "home";
	}
	
	@RequestMapping("/logoutUser")
	public String logsout(Model model){
		
			List<GrantedAuthority> ga=new ArrayList<GrantedAuthority>();
			ga.add(new SimpleGrantedAuthority("ROLE_USER"));
			SecurityContextHolder.getContext().setAuthentication(new AnonymousAuthenticationToken("key","Anonymous",ga));
			model.addAttribute("user",SecurityContextHolder.getContext().getAuthentication().getName());
			model.addAttribute("role",SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		
		return "home";
	}
	
	

	    @GetMapping(value = "/authorize")
  		public void authorize(HttpServletResponse res) throws JsonProcessingException, IOException {
  			
    	
  		   logger.info("Inside authorize");
  		 		 	
  		  
  			String url=authorizationUri;
  			url+="?response_type=code";
  		 	url+="&client_id="+clientId;
  		 	url+="&redirect_uri="+callbackUri;
  		 	url+="&scope=read";
		 
  			res.sendRedirect(url);
	    }
	    
	    
	    
	    @RequestMapping(value = "/callback")
	  		public String getToken(@RequestParam("code") String code,HttpServletRequest req,Model model,HttpSession session) throws JsonProcessingException, IOException {
	  			
	    	
	    		logger.info("Inside callback");
	    		
	    	
	    		 
	  		 	ResponseEntity<String> response = null;

	  			  			
	  			String credentials = clientId+":"+clientSecret;
	  			String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

	  			HttpHeaders headers = new HttpHeaders();
	  			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	  			headers.add("Authorization", "Basic " + encodedCredentials);

	  			HttpEntity<String> request = new HttpEntity<String>(headers);

	  			String access_token_url = tokenUri;
	  			access_token_url += "?code=" + code;
	  			access_token_url += "&grant_type=authorization_code";
	  			access_token_url += "&redirect_uri="+callbackUri;
	  				  		

	  			response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);

	  			
	  			
	  			ObjectMapper mapper = new ObjectMapper();
	  			JsonNode node = mapper.readTree(response.getBody());
	  			String token = node.path("access_token").asText();
	  			String tokenType = node.path("token_type").asText();
	  			
	  			session.setAttribute("access_token", token);

	  			  			
	  			
	  			// Use the access token for authentication
	  			HttpHeaders headers1 = new HttpHeaders();
	  			headers1.add("Authorization", "Bearer "+ session.getAttribute("access_token"));
	  			headers1.add("content-type",MediaType.APPLICATION_JSON_VALUE);
	  			HttpEntity<String> entity = new HttpEntity<>(headers1);


	  			
	  			ResponseEntity<User> userResponse = restTemplate.exchange(userInfoUri, HttpMethod.GET, entity, User.class);
	  			
	  			User loggedInUser =  userResponse.getBody();
	  			
	  			logger.info("User  ----- "+loggedInUser.getUserName());
	  			
	  			model.addAttribute("user", loggedInUser.getUserName());
	  			
	  			logger.info("User  ----- "+loggedInUser.getRoles());
	  			
	  			
	  			
	  			List<GrantedAuthority> ga=new ArrayList<GrantedAuthority>();
	  			loggedInUser.getRoles().getPermissions().forEach(permission->ga.add(new SimpleGrantedAuthority(permission.getPermissionName().toUpperCase())));
				ga.add(new SimpleGrantedAuthority("ROLE_"+loggedInUser.getRoles().getRoleName().toUpperCase()));
				
				model.addAttribute("role", ga.toString());
				
				session.setAttribute("role", token);
	  			
	  			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(loggedInUser.getUserName(),loggedInUser.getPassword(),ga));

	  			return "home";
	  		

	  			
	  		}
	    
	    
	    @RequestMapping(value = "/utilities")
  		public String getToken(Model model,HttpSession session,HttpServletResponse res) throws JsonProcessingException, IOException {
	    	
	    	
	    	
  		    logger.info("Inside utilities");
	    	
	    	// Use the access token for authentication
  			HttpHeaders headers1 = new HttpHeaders();
  			headers1.add("Authorization", "Bearer "+ session.getAttribute("access_token"));
  			headers1.add("content-type",MediaType.APPLICATION_JSON_UTF8_VALUE);
  			HttpEntity<String> entity = new HttpEntity<>(headers1);

 			
  			ResponseEntity<Utility[]> userResponse = restTemplate.exchange("http://localhost:8083/utilityservice/v1/utilities", HttpMethod.GET, entity, Utility[].class);
  				
  			model.addAttribute("utilities", userResponse.getBody());
  			model.addAttribute("role",SecurityContextHolder.getContext().getAuthentication().getAuthorities() );
  		 			
	    	return "home";
  			
	    }

}
