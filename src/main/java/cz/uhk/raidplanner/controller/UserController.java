package cz.uhk.raidplanner.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.raidplanner.entity.MyCharacter;
import cz.uhk.raidplanner.entity.User;
import cz.uhk.raidplanner.service.MyCharacterService;
import cz.uhk.raidplanner.service.UserService;


@Controller
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MyCharacterService myCharacterService;
	
	
	
	@ModelAttribute("myCharacter") //bindnuti z form:form commandName z user-detail.jsp
	public MyCharacter constructMyCharacter() {
		return new MyCharacter();
	}
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		String login = principal.getName();
		model.addAttribute("user", userService.findOneWithCharacters(login));
		return "account";
	}
	
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String doAddMyCharacter(Model model, @Valid @ModelAttribute("myCharacter") MyCharacter myCharacter, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			return account(model, principal);
		}
		String login = principal.getName();
		myCharacterService.save(myCharacter, login);
		return "redirect:/account.html";
	}
	
	@RequestMapping("/character/remove/{id}")
	public String removeCharacter(@PathVariable int id) {
		MyCharacter myCharacter = myCharacterService.findOne(id);
		myCharacterService.delete(myCharacter);
		return "redirect:/account.html";		
	}
	
	
}






