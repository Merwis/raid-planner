package cz.uhk.raidplanner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.raidplanner.entity.MyCharacter;
import cz.uhk.raidplanner.entity.Role;
import cz.uhk.raidplanner.entity.User;

public interface MyCharacterRepository extends JpaRepository<MyCharacter, Integer>{

	List<MyCharacter> findByUser(User user);
	
	
}
