package cz.uhk.raidplanner.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(Model model, Principal user) {
 
		if (user != null) {
			model.addAttribute("msg", "Mil� u�ivateli " + user.getName() 
			+ ", a� u� jsi se pokusil o cokoliv, nem� k tomu pot�ebn� opr�vn�n�. S pozdravem admin.");
		} else {
			model.addAttribute("msg", 
			"Nem�te opr�vn�n� k t�to akci.");
		}
 
		return "403";
 
	}
	
}
