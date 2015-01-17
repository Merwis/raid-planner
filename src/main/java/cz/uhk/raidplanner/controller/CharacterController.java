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
import cz.uhk.raidplanner.service.MyCharacterService;

@Controller
@RequestMapping("/character")
public class CharacterController {
	
	@Autowired
	private MyCharacterService myCharacterService;
	
	@ModelAttribute("updateMyCharacter") //bindnuti z form:form commandName z user-detail.jsp
	public MyCharacter constructMyCharacter() {
		return new MyCharacter();
	}
	
	@RequestMapping("/{id}")
	public String detail(Model model, @PathVariable int id, Principal principal) {
		model.addAttribute("myCharacter", myCharacterService.findOne(id));
		MyCharacter myCharacter =  myCharacterService.findOne(id);
		
		if (myCharacter == null) {
			return "404";
		}
		
		if (myCharacter.getUser().getLogin() == principal.getName()) {
			return "character-edit";
		} else {
			return "character-detail";
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String updateMyCharacter(Model model, @PathVariable int id, @Valid @ModelAttribute("updateMyCharacter") MyCharacter myCharacter, BindingResult result) {
		if (result.hasErrors()) {
			return "";
		}
		MyCharacter char1 = myCharacterService.findOne(id);
		char1.setName(myCharacter.getName());
		char1.setCharClass(myCharacter.getCharClass());
		myCharacterService.update(char1);
		return "redirect:/account.html";
	}
	
/*	@RequestMapping("/character/remove/{id}")
	public String removeCharacter(@PathVariable int id) {
		MyCharacter myCharacter = myCharacterService.findOne(id);
		myCharacterService.delete(myCharacter);
		return "redirect:/account.html";		
	}*/

}
