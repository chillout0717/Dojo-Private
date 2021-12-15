package com.codingdojo.dojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojo.models.Dojo;
import com.codingdojo.dojo.models.Ninja;
import com.codingdojo.dojo.services.NinjaDojoService;

@Controller
@RequestMapping("/ninja")
public class NinjaController {

	@Autowired
	private NinjaDojoService ninjaDojoService;
	
	@GetMapping("/new")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojo = ninjaDojoService.allDojo();
		model.addAttribute("allDojo", allDojo);
		return "newNinja.jsp";
	}
	
	@PostMapping("/createNinja")
	public String ninjaCreate(@Valid @ModelAttribute("ninja") Ninja ninja, Model model, BindingResult result) {
		if(result.hasErrors()) {
			List<Dojo> allDojo = ninjaDojoService.allDojo();
			model.addAttribute("allDojo", allDojo);
			return "newNinja.jsp";
		}
		ninjaDojoService.createNinja(ninja);
		return "redirect:/dojo/"+ninja.getDojo().getId();
	}
}
