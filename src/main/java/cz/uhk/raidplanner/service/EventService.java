package cz.uhk.raidplanner.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import cz.uhk.raidplanner.entity.Event;
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

	@PreAuthorize(value="hasRole('ROLE_ADMIN') OR hasRole('ROLE_OFFICER')")
	public void delete(int id) {
		eventRepository.delete(id);
	}

	public Event findOne(int id) {
		Event event;
		try {
			event = eventRepository.findOne(id);
		} catch (Exception e) {
			event = null;
		}
		return event;
		
	}

	public void save(Event event) {
		eventRepository.save(event);
		
	}

}
