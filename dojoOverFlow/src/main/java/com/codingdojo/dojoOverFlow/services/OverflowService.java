package com.codingdojo.dojoOverFlow.services;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojoOverFlow.models.Answer;
import com.codingdojo.dojoOverFlow.models.Question;
import com.codingdojo.dojoOverFlow.models.Tag;
import com.codingdojo.dojoOverFlow.repositories.AnswerRepository;
import com.codingdojo.dojoOverFlow.repositories.QuestionRepository;
import com.codingdojo.dojoOverFlow.repositories.TagRepository;

@Service
public class OverflowService {
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private AnswerRepository aRepo;
	@Autowired
	private TagRepository tRepo;
	
	public Tag getOneTag(String subject) {
		return tRepo.findBySubject(subject);
		
	}
	
	
	public ArrayList<Tag> splitTags(String tags) {
		ArrayList<Tag> tagForQ = new ArrayList<Tag>();
		String[] tagsToProcess = tags.split(", ");
		for(String s : tagsToProcess) {
			if(tRepo.existsBySubject(s)) {
				Tag tagToAdd = getOneTag(s);
				tagForQ.add(tagToAdd);
			}else {
				Tag newTag = new Tag();
				newTag.setSubject(s);
				tRepo.save(newTag);
				tagForQ.add(getOneTag(s));
			}
		}
		return tagForQ;
	}
	
	public Question createQuestion(Question question) {
		question.setTags(splitTags(question.getTagsFromFrontEnd()));
		return qRepo.save(question);
	}
	
	public Answer createAnswer(Answer answer) {
		return aRepo.save(answer);
	}
	
	public List<Question> getAllQuestions(){
		return qRepo.findAll();
	}
	
	public Question findOneQuestion(Long id) {
		return qRepo.findById(id).orElse(null);
	}
}
