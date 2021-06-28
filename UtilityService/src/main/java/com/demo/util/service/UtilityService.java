package com.demo.util.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.util.iservice.IUtilityService;
import com.demo.util.iservice.UtilityRepository;
import com.demo.util.model.Utility;




@Service
public class UtilityService implements IUtilityService{

	@Autowired
	UtilityRepository utilityRepo;
	
	
	
	Logger log=LoggerFactory.getLogger(UtilityService.class);

	@Override
	public void save(Utility utility) {
			log.info("saving utility");
			utilityRepo.save(utility);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Optional<Utility> update(int utilityId, Utility utility) {
		
		
			return utilityRepo.findById(utilityId);
				
	}
	
	@Override
	public void delete(int utilityId) {
		utilityRepo.deleteById(utilityId);
	}

	@Override
	public List<Utility> getUtilities() {
		
		List<Utility> utilitys=utilityRepo.findAll();
		
		return utilitys;
	}

	@Override
	public Optional<Utility> getUtilityById(int utilityId) {
		
		
			return utilityRepo.findById(utilityId);
	
	}

	
	@Override
	public Utility getUtilityByUtilityName(String utilityName) {
		
		return utilityRepo.findByUtilityName(utilityName);
	}


}
