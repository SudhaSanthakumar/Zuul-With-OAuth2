package com.demo.util.iservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.util.model.Utility;



@Repository
public interface UtilityRepository extends JpaRepository<Utility, Integer> {

	Utility findByUtilityName(String utilityName);
}
