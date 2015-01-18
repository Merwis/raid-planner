package cz.uhk.raidplanner.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.raidplanner.entity.EventTemplate;
import cz.uhk.raidplanner.service.EventTemplateService;

@Controller
@RequestMapping("/event")
public class EventTemplateController {
	
	@Autowired
	private EventTemplateService eventTemplateService;

	
	@ModelAttribute("eventTemplate") //bindnuti z form:form commandName z user-detail.jsp
	public EventTemplate constructEventTemplate() {
		return new EventTemplate();
	}
	
	@ModelAttribute("eventTemplateUpdate") //bindnuti z form:form commandName z user-detail.jsp
	public EventTemplate constructEventTemplateUpdate() {
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
	
	@RequestMapping(value="/template/detail/{id}", method=RequestMethod.POST)
	public String doUpdateEventTemplate(Model model, @PathVariable int id, @Valid @ModelAttribute("eventTemplateUpdate") EventTemplate eventTemplate, BindingResult result) {
		if (result.hasErrors()) {
			return detailEventTemplate(model, id);
		}
		eventTemplateService.save(eventTemplate);
		return detailEventTemplate(model, id);
	}
	
	@RequestMapping("/template/detail/{id}")
	public String detailEventTemplate(Model model, @PathVariable int id) {
		EventTemplate eventTemplate = eventTemplateService.findOne(id);
		if (eventTemplate == null) {
			return "404";
		}
		model.addAttribute("eventTemplate", eventTemplate);
		return "event-template-detail";
	}
}
