package com.codingdojo.dojo.repositoies;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojo.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{

	
	
}
