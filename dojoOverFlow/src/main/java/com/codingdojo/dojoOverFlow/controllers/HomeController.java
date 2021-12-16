package com.codingdojo.dojoOverFlow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojoOverFlow.models.Answer;
import com.codingdojo.dojoOverFlow.models.Question;
import com.codingdojo.dojoOverFlow.services.OverflowService;
import com.codingdojo.dojoOverFlow.valid.TagValidator;

@Controller
public class HomeController {

	@Autowired
	private OverflowService oService;
	@Autowired
	private TagValidator validator;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allQ", oService.getAllQuestions());
		return "index.jsp";
	}
	
	@GetMapping("/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}
	
	@PostMapping("/newQuestion")
	public String addQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		validator.validate(question, result);
		
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		}
		oService.createQuestion(question);
		return "redirect:/";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer) {
		model.addAttribute("question", oService.findOneQuestion(id));
		return "show.jsp";
	}
	
	@PostMapping("/addAnswer")
	public String addAnswer(@Valid @ModelAttribute("answer")Answer answer, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question", oService.findOneQuestion(answer.getQuestion().getId()));
			return "show.jsp";
		}
		
		oService.createAnswer(answer);
		return "redirect:/show/"+answer.getQuestion().getId();
	}
	
	
}
