package cz.uhk.raidplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.raidplanner.entity.MyCharacter;
import cz.uhk.raidplanner.entity.Role;

public interface MyCharacterRepository extends JpaRepository<MyCharacter, Integer>{

}
