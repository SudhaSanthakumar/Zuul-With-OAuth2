package com.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class DatabaseInit implements ApplicationListener<ApplicationReadyEvent> {

	
	Logger log=LoggerFactory.getLogger(DatabaseInit.class);
	
		
	
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		
//		Utility u1=new Utility("Laptop");
//		Utility u2=new Utility("Monitor");
//		Utility u3=new Utility("TV");
//		Utility u4=new Utility("Electrical");
//		
//		uRepository.save(u1);
//		uRepository.save(u2);
//		uRepository.save(u3);
//		uRepository.save(u4);
//		
		
	}
}
