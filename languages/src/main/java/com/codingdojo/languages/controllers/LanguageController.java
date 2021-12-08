package com.codingdojo.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("language") Language language) {
		model.addAttribute("getAllLanguages", languageService.allLang());
		return "index.jsp";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String addLang(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("getAllLanguages", languageService.allLang());
			return "index.jsp";
		}
		languageService.createLang(language);
		return "redirect:/";
	}
	
	@RequestMapping("/show/{id}")
	public String showLang(Model model, @PathVariable("id") Long id) {
		model.addAttribute("getLanguage", languageService.findLang(id));
		return "show.jsp";
	}
	
	@RequestMapping("/edit/{id}")
	public String editLang(Model model, @PathVariable("id") Long id) {
		model.addAttribute("editLanguage", languageService.findLang(id));
		return "edit.jsp";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	public String updateLang(@Valid @ModelAttribute("editLanguage") Language language, BindingResult result, Model model, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			model.addAttribute("editLanguage", languageService.findLang(id));
			return "edit.jsp";
		}
		languageService.updateLang(language);
		return "redirect:/show/{id}";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String deleteLang(@PathVariable("id") Long id) {
		languageService.deleteLang(id);
		return "redirect:/";
	}

}
