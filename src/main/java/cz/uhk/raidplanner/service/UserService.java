package cz.uhk.raidplanner.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.raidplanner.entity.Equipment;
import cz.uhk.raidplanner.entity.MyCharacter;
import cz.uhk.raidplanner.entity.User;
import cz.uhk.raidplanner.repository.EquipmentRepository;
import cz.uhk.raidplanner.repository.MyCharacterRepository;
import cz.uhk.raidplanner.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MyCharacterRepository myCharacterRepository;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {		
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithCharacters(int id) {
		User user = findOne(id);
		List<MyCharacter> characters = myCharacterRepository.findByUser(user);
		/*for (MyCharacter myCharacter : characters) {
			Equipment equip =  equipmentRepository.findByCharacter(myCharacter);
			myCharacter.setEquip(equip);
		}*/
		user.setCharacters(characters);
		return user;
	}
}
