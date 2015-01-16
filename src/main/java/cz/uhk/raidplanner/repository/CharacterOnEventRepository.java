package cz.uhk.raidplanner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.raidplanner.entity.CharacterOnEvent;
import cz.uhk.raidplanner.entity.Event;
import cz.uhk.raidplanner.entity.MyCharacter;

public interface CharacterOnEventRepository extends JpaRepository<CharacterOnEvent, Integer> {

	List<CharacterOnEvent> findByEvent(Event event);

	CharacterOnEvent findByEventAndMyCharacter(Event event, MyCharacter myCharacter);

}
