package cz.uhk.raidplanner.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cz.uhk.raidplanner.entity.Equipment;
import cz.uhk.raidplanner.entity.MyCharacter;
import cz.uhk.raidplanner.entity.Role;
import cz.uhk.raidplanner.entity.User;
import cz.uhk.raidplanner.repository.EquipmentRepository;
import cz.uhk.raidplanner.repository.MyCharacterRepository;
import cz.uhk.raidplanner.repository.RoleRepository;
import cz.uhk.raidplanner.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MyCharacterRepository myCharacterRepository;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
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

	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		user.setPassword(bc.encode(user.getPassword()));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		userRepository.save(user);
	}

	public User findOneWithCharacters(String login) {
		User user = userRepository.findByLogin(login);
		return findOneWithCharacters(user.getId());
	}

	public void delete(int id) {
		userRepository.delete(id);
	}
}
