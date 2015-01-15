package cz.uhk.raidplanner.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.raidplanner.entity.Event;
import cz.uhk.raidplanner.entity.MyCharacter;
import cz.uhk.raidplanner.repository.EventRepository;
import cz.uhk.raidplanner.repository.MyCharacterRepository;

@Service
@Transactional
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private MyCharacterRepository myCharacterRepository;

	public List<Event> findAll() {
		return eventRepository.findAll();
	}

	public void delete(int id) {
		eventRepository.delete(id);
	}

	public Event findOne(int id) {
		Event event = eventRepository.findOne(id);
/*		List<MyCharacter> characters = new ArrayList<MyCharacter>(); // myCharacterRepository.findByEvents(event.getId());
		
		MyCharacter char5 = new MyCharacter();
		char5.setName("Hlavní postavièka 1");
		char5.setCharClass("Gunslinger");
		myCharacterRepository.save(char5);
		characters.add(char5);
		event.setCharacters(characters);*/
		return event;
		
	}

	public void save(Event event) {
		eventRepository.save(event);
		
	}

}
