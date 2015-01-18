package cz.uhk.raidplanner.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.raidplanner.entity.Role;
import cz.uhk.raidplanner.entity.User;
import cz.uhk.raidplanner.service.RoleService;
import cz.uhk.raidplanner.service.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@RequestMapping
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@RequestMapping("/{id}")
	public String detail(Model model, @PathVariable int id) {
		User user = userService.findOneWithCharacters(id);
		if (user == null) {
			return "404";
		}
		model.addAttribute("user", user);
		return "user-detail";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/users.html";
	}
	
	@RequestMapping(value="/{id}/editroles", method=RequestMethod.POST)
	public String updateUserRole(Model model, @PathVariable int id, HttpServletRequest request) {

		User user1 = userService.findOne(id);
		List<Role> roles = new ArrayList<Role>();
		String role = request.getParameter("role");
		Role roleAmin = roleService.findByName("ROLE_ADMIN");
		Role roleOfficer = roleService.findByName("ROLE_OFFICER");
		Role roleUser = roleService.findByName("ROLE_USER");
		if (role.equals("o")) {
			roles.add(roleOfficer);
			roles.add(roleUser);
		} else if (role.equals("a")) {
			roles.add(roleAmin);
			roles.add(roleOfficer);
			roles.add(roleUser);
		} else {
			roles.add(roleUser);
		}
		user1.setRoles(roles);
		userService.update(user1);
		return "redirect:/users/{id}.html";
	}
}
