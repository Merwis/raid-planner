package cz.uhk.raidplanner.controller;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.raidplanner.entity.Actuality;
import cz.uhk.raidplanner.entity.EventTemplate;
import cz.uhk.raidplanner.entity.User;
import cz.uhk.raidplanner.service.ActualityService;
import cz.uhk.raidplanner.service.UserService;

@Controller
public class ActualityController {
	
	@Autowired
	ActualityService actualityService;
	
	@Autowired
	UserService userService;

	@ModelAttribute("actualityAdd") //bindnuti z form:form commandName z user-detail.jsp
	public Actuality constructActuality() {
		return new Actuality();
	}
	
	
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String showNews(Model model) {
		model.addAttribute("actualities", actualityService.findAll());
	    return "news";
	}
	
	@RequestMapping(value="/news", method=RequestMethod.POST)
	public String doAddEventTemplate(Model model, @Valid @ModelAttribute("actualityAdd") Actuality actuality, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			return showNews(model);
		}
		User user = userService.findOne(principal.getName());
		Date date = new Date();
		actuality.setAuthor(user);
		actuality.setDate(date);
		actualityService.save(actuality);
		return "redirect:/news.html";
	}
}
