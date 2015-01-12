package cz.uhk.raidplanner.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.raidplanner.entity.EventTemplate;
import cz.uhk.raidplanner.repository.EventTemplateRepository;

@Service
@Transactional
public class EventTemplateService {

	@Autowired
	EventTemplateRepository eventTemplateRepository;

	public List<EventTemplate> findAll() {
		return eventTemplateRepository.findAll();
	}

	public void delete(int id) {
		eventTemplateRepository.delete(id);
	}

	public void save(EventTemplate eventTemplate) {
		eventTemplateRepository.save(eventTemplate);		
	}

	public EventTemplate findOne(int id) {
		return eventTemplateRepository.findOne(id);
	}
}
