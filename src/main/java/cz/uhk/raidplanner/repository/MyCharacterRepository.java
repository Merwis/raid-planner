package cz.uhk.raidplanner.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cz.uhk.raidplanner.entity.Event;
import cz.uhk.raidplanner.entity.MyCharacter;
import cz.uhk.raidplanner.entity.Role;
import cz.uhk.raidplanner.entity.User;

public interface MyCharacterRepository extends JpaRepository<MyCharacter, Integer>{

	List<MyCharacter> findByUser(User user);

	List<MyCharacter> findByEventsIn(Event event);
	
//	public final static String FIND_CHARACTERS = "select c.id from Mycharacter c " +
//											   "inner join mycharacter_event p1 on c.id = p1.mycharacters_id " + 
//											   //"join event on mycharacter_event.events_id = event.id " +
//											   "where p1.events_id = :id";
//
//
//@Query(FIND_CHARACTERS)
//public List<MyCharacter> findByEvents(@Param("id") int id);
	
	
}
