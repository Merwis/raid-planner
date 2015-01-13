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

import cz.uhk.raidplanner.entity.Event;
import cz.uhk.raidplanner.entity.EventTemplate;
import cz.uhk.raidplanner.entity.MyCharacter;
import cz.uhk.raidplanner.entity.User;
import cz.uhk.raidplanner.service.EventService;
import cz.uhk.raidplanner.service.EventTemplateService;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@ModelAttribute("event") //bindnuti z form:form commandName z user-detail.jsp
	public Event constructEvent() {
		return new Event();
	}
	
	@RequestMapping("/list")
	public String showEventList(Model model) {
		model.addAttribute("events", eventService.findAll());
		return "event-list";
	}
	
	
	
	
	
	
	
	// EVENT TEMPLATES
	
	@Autowired
	private EventTemplateService eventTemplateService;
	
	@ModelAttribute("eventTemplate") //bindnuti z form:form commandName z user-detail.jsp
	public EventTemplate constructEventTemplate() {
		return new EventTemplate();
	}
	
	@RequestMapping("/template/list")
	public String showEventTemplateList(Model model) {
		model.addAttribute("eventTemplate", eventTemplateService.findAll());
		return "event-template-list";
	}
	
	@RequestMapping("/template/remove/{id}")
	public String removeEventTemplate(@PathVariable int id) {
		eventTemplateService.delete(id);
		return "redirect:/event/template/list.html";
	}
	
	@RequestMapping("/template/create")
	public String showCreateEventTemplate(){
		return "event-template-create";
	}
	
	@RequestMapping(value="/template/create", method=RequestMethod.POST)
	public String doAddEventTemplate(Model model, @Valid @ModelAttribute("eventTemplate") EventTemplate eventTemplate, BindingResult result) {
		if (result.hasErrors()) {
			return showCreateEventTemplate();
		}
		eventTemplateService.save(eventTemplate);
		return "redirect:/event/template/list.html";
	}
	
	@RequestMapping("/template/detail/{id}")
	public String detailEventTemplate(Model model, @PathVariable int id) {
		model.addAttribute("eventTemplate", eventTemplateService.findOne(id));
		return "event-template-detail";
	}

}
