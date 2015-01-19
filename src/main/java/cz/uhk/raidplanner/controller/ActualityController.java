package cz.uhk.raidplanner.controller;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.raidplanner.entity.Actuality;
import cz.uhk.raidplanner.entity.EventTemplate;
import cz.uhk.raidplanner.entity.User;
import cz.uhk.raidplanner.service.ActualityService;
import cz.uhk.raidplanner.service.UserService;

@Controller
@RequestMapping("/news")
public class ActualityController {
	
	@Autowired
	ActualityService actualityService;
	
	@Autowired
	UserService userService;

	@ModelAttribute("actualityAdd") //bindnuti z form:form commandName z user-detail.jsp
	public Actuality constructActuality() {
		return new Actuality();
	}
	
	@ModelAttribute("actualityEdit") //bindnuti z form:form commandName z user-detail.jsp
	public Actuality constructActualityEdit() {
		return new Actuality();
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showNews(Model model) {
		model.addAttribute("actualities", actualityService.findAllByOrderByPublishedDesc());
	    return "news";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editNews(Model model, @PathVariable int id) {
		model.addAttribute("actuality", actualityService.findOneById(id));
	    return "news-edit";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String doAddEventTemplate(Model model, @Valid @ModelAttribute("actualityAdd") Actuality actuality, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			return showNews(model);
		}
		User user = userService.findOne(principal.getName());
		Date date = new Date();
		actuality.setAuthor(user);
		actuality.setPublished(date);
		actualityService.save(actuality);
		return "redirect:/news.html";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public String doEditNews(Model model, @Valid @ModelAttribute("actualityAdd") Actuality actuality, BindingResult result, @PathVariable int id, 
			Principal principal ) {
		if (result.hasErrors()) {
			return editNews(model, id);
		}
		Actuality oldActuality = actualityService.findOneById(id);
		
		User user = userService.findOne(principal.getName());
		oldActuality.setAuthor(user);
		oldActuality.setEdited(new Date());
		oldActuality.setHeader(actuality.getHeader());
		oldActuality.setText(actuality.getText());
		actualityService.save(oldActuality);
		return "redirect:/news.html";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeActuality(@PathVariable int id) {
		actualityService.delete(id);
		return "redirect:news.html";
	}
	
	
}
