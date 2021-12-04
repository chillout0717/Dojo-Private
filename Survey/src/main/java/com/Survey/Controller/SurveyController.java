package com.Survey.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

	@Controller
	public class SurveyController {
		
		@RequestMapping("/")
		public String index(){
			return "index.jsp";
		}
		
		@RequestMapping(value="/result", method=RequestMethod.POST)
		public String survey(@RequestParam("name") String name, @RequestParam("location") String location, 
									@RequestParam("language") String language, @RequestParam("comment") String comment, Model model) {
		
			model.addAttribute("name", name);
			model.addAttribute("location", location);
			model.addAttribute("language", language);
			model.addAttribute("comment", comment);
			
			return "result.jsp";
		}
}
