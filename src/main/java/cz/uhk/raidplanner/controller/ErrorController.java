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
			model.addAttribute("msg", "Mil˝ uûivateli " + user.getName() 
			+ ", aù uû jsi se pokusil o cokoliv, nem·ö k tomu pot¯ebn· opr·vnÏnÌ. S pozdravem admin.");
		} else {
			model.addAttribute("msg", 
			"Nem·te opr·vnÏnÌ k tÈto akci.");
		}
 
		return "403";
 
	}
	
}
