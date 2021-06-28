package com.demo.util.iservice;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.util.model.Utility;



@Service
public interface IUtilityService {

	public void save(Utility utility);
	
	public Optional<Utility> update(int utilityId,Utility utility);
	
	public void delete(int utilityId);
	
	public Optional<Utility> getUtilityById(int utilityId);
	
	public Utility getUtilityByUtilityName(String utilityName);

	public List<Utility> getUtilities();
	
	
}
