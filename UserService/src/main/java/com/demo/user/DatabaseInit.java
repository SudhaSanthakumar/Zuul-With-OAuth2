package com.demo.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class DatabaseInit implements ApplicationListener<ApplicationReadyEvent> {

	
	Logger log=LoggerFactory.getLogger(DatabaseInit.class);
	
		
//	@Autowired
//	private UtilityRepository uRepository;
	
	

	
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		
		
		
	}
}
