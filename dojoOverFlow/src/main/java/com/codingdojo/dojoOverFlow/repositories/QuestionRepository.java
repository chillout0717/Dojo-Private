package com.codingdojo.dojoOverFlow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojoOverFlow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{

	List<Question> findAll();
}
