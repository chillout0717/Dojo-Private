package com.codingdojo.dojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojo.models.Dojo;
import com.codingdojo.dojo.models.Ninja;
import com.codingdojo.dojo.repositoies.DojoRepository;
import com.codingdojo.dojo.repositoies.NinjaRepository;

@Service
public class NinjaDojoService {

	@Autowired
	private NinjaRepository ninjaRepo;
	@Autowired
	private DojoRepository dojoRepo;
	
	
	public List<Dojo> allDojo(){
		return dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Dojo getOneDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	
	
}
