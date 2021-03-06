package cz.uhk.raidplanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.raidplanner.entity.CharacterOnEvent;
import cz.uhk.raidplanner.entity.Event;
import cz.uhk.raidplanner.entity.MyCharacter;
import cz.uhk.raidplanner.repository.CharacterOnEventRepository;
import cz.uhk.raidplanner.repository.MyCharacterRepository;

@Service
public class CharacterOnEventService {

	@Autowired 
	private CharacterOnEventRepository characterOnEventRepository;
	
	@Autowired
	private MyCharacterRepository myCharacterRepository;

	public List<CharacterOnEvent> findAllWithEvent(Event event) {
		List<CharacterOnEvent> coe = characterOnEventRepository.findByEvent(event);
		return coe;
	}

	public void save(CharacterOnEvent coe) {
		characterOnEventRepository.save(coe);
		
	}

	public CharacterOnEvent findOneWithEvent(Event event, MyCharacter myCharacter) {
		return characterOnEventRepository.findByEventAndMyCharacter(event, myCharacter);		
	}
}
