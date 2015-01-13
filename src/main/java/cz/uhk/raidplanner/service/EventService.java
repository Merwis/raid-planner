package cz.uhk.raidplanner.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.raidplanner.entity.Event;
import cz.uhk.raidplanner.repository.EventRepository;

@Service
@Transactional
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;

	public List<Event> findAll() {
		return eventRepository.findAll();
	}

}
