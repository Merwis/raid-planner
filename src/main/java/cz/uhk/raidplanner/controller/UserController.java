package cz.uhk.raidplanner.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@ModelAttribute("updateUser") //bindnuti z form:form commandName z user-detail.jsp
	public User constructUser() {
		return new User();
	}
	
	@ModelAttribute("updateUserPassword") //bindnuti z form:form commandName z user-detail.jsp
	public User constructUserPassword() {
		return new User();
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
	
	@RequestMapping("user/edit/{id}")
	public String editUser(Model model, @PathVariable int id, Principal principal) {		
		model.addAttribute("user", userService.findOne(id));
		User user =  userService.findOne(id);
		if (user.getLogin().toString().equals(principal.getName().toString())) {
			return "user-edit";
		} else {
			return "redirect:/account.html";
		}
	}
	
	@RequestMapping(value="/user/edit/{id}", method=RequestMethod.POST)
	public String updateUser(Model model, @PathVariable int id, @Valid @ModelAttribute("updateUser") User user, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			return editUser(model, id, principal);
		}
		
		User user1 = userService.findOne(id);
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		/*if (user.getPassword() !="") {
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			user1.setPassword(bc.encode(user.getPassword()));
		}*/
		userService.update(user1);
		return "redirect:/account.html";
	}
	
	@RequestMapping(value="/user/edit/password/{id}", method=RequestMethod.POST)
	public String updateUserPassword(Model model, @PathVariable int id, @Valid @ModelAttribute("updateUser") User user, BindingResult result, 
			Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return editUser(model, id, principal);
		}
		User user1 = userService.findOne(id);
		if (user1.getLogin().toString().equals(principal.getName().toString())) {
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			String oldPassword = request.getParameter("oldpassword");
			if (bc.matches(oldPassword, user1.getPassword())) {
				user1.setPassword(bc.encode(user.getPassword()));
				userService.update(user1);
				
				redirectAttributes.addFlashAttribute("success", true);
				return "redirect:/account.html";
			}
		} 
		redirectAttributes.addFlashAttribute("failed", true);
		return "redirect:/user/edit/{id}.html";
	}	
	
}






