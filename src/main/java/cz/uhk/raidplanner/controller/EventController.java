package cz.uhk.raidplanner.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.raidplanner.entity.CharacterOnEvent;
import cz.uhk.raidplanner.entity.Event;
import cz.uhk.raidplanner.entity.EventTemplate;
import cz.uhk.raidplanner.entity.MyCharacter;
import cz.uhk.raidplanner.entity.User;
import cz.uhk.raidplanner.service.CharacterOnEventService;
import cz.uhk.raidplanner.service.Editor;
import cz.uhk.raidplanner.service.EditorCharacter;
import cz.uhk.raidplanner.service.EditorEvent;
import cz.uhk.raidplanner.service.EventService;
import cz.uhk.raidplanner.service.EventTemplateService;
import cz.uhk.raidplanner.service.MyCharacterService;
import cz.uhk.raidplanner.service.UserService;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private MyCharacterService myCharacterService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private CharacterOnEventService characterOnEventService;
	
	@Autowired
	private EventTemplateService eventTemplateService;
	
	@ModelAttribute("eventCreate") //bindnuti z form:form commandName z user-detail.jsp
	public Event constructEvent() {
		return new Event();
	}
	
	@ModelAttribute("characterAvailability") //bindnuti z form:form commandName z user-detail.jsp
	public CharacterOnEvent constructCharacterOnEvent() {
		return new CharacterOnEvent();
	}
	
	@RequestMapping("/list")
	public String showEventList(Model model) {
		model.addAttribute("events", eventService.findAll());
		return "event-list";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeEvent(@PathVariable int id) {
		eventService.delete(id);
		return "redirect:/event/list.html";
	}
	
	@RequestMapping("/detail/{id}")
	public String detailEvent(Model model, @PathVariable int id, Principal principal) {
		model.addAttribute("event", eventService.findOne(id));
		Event event = eventService.findOne(id);
		
		List<CharacterOnEvent> coe = characterOnEventService.findAllWithEvent(event);
		List<CharacterOnEvent> coeC = new ArrayList<CharacterOnEvent>();
		List<CharacterOnEvent> coeA = new ArrayList<CharacterOnEvent>();
		List<CharacterOnEvent> coeN = new ArrayList<CharacterOnEvent>();
		
		for (int i = 0; i < coe.size(); i++) {
			if (coe.get(i).getStatus().equals("confirmed")) {
				coeC.add(coe.get(i));
			} else {
				if (coe.get(i).getStatus().equals("available")) {
					coeA.add(coe.get(i));
				} else {
					if (coe.get(i).getStatus().equals("notavailable")) {
						coeN.add(coe.get(i));
					}
				}
			}
		}
		
		model.addAttribute("coeC", coeC);
		model.addAttribute("coeA", coeA);
		model.addAttribute("coeN", coeN);
		model.addAttribute("coe", coe);
		
		String login = principal.getName();
		User user = userService.findOne(login);
		model.addAttribute("characters", myCharacterService.findAllByUser(user));
		
		return "event-detail";
	}
	
	@RequestMapping(value="/detail/{id}/characters", method=RequestMethod.POST)
	public String doAddCharacterOnEvent(Model model, @Valid @ModelAttribute("characterAvailability") CharacterOnEvent coe, BindingResult result, 
			@PathVariable int id, Principal principal) {
		if (result.hasErrors()) {
			return detailEvent(model, id, principal);
		}
		characterOnEventService.save(coe);
		//eventTemplateService.save(eventTemplate);
		return "redirect:/event/detail/{id}.html";
	}
	
	@RequestMapping("/create")
	public String showCreateEvent(Model model){
		model.addAttribute("et", eventTemplateService.findAll());
		
		return "event-create";
	}
	
	// Binder pro napojení EventTemplate na id prichazejici z formulare pomoci tridy Editor
	@InitBinder
	protected void initBinder(WebDataBinder binder){
	    binder.registerCustomEditor(EventTemplate.class, new Editor(eventTemplateService));
	    binder.registerCustomEditor(MyCharacter.class, new EditorCharacter(myCharacterService));
	    binder.registerCustomEditor(Event.class, new EditorEvent(eventService));
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String doAddEvent(Model model, @Valid @ModelAttribute("eventCreate") Event event, BindingResult result) {
		if (result.hasErrors()) {
			return showCreateEvent(model);
		}
		
		eventService.save(event);
		//eventTemplateService.save(eventTemplate);
		return "redirect:/event/list.html";
	}
	
	
	
	
	
	// EVENT TEMPLATES
	
	
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
