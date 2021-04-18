package com.example.hms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.models.Suite;
import com.example.hms.repo.SuiteRepository;

@Service
public class SuiteService {
	
	private SuiteRepository suiteRepository;

	@Autowired
	public SuiteService(SuiteRepository suiteRepository) {
		this.suiteRepository = suiteRepository;
	}
	
	public Suite createSuite(String longDescription, String description, String name, String code) {
		return suiteRepository.findById(code)
		.orElse(suiteRepository.save(new Suite(code, name, description, longDescription))); 
	}
	
	public Suite getSuiteByCode(String code) {
		return suiteRepository.findById(code).orElse(null);
		
	}
	
	public Suite getSuiteByName(String name) {
		return suiteRepository.findByName(name).orElse(null);
		
	}

}
