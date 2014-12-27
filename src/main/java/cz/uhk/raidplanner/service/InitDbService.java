package cz.uhk.raidplanner.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.raidplanner.entity.Equipment;
import cz.uhk.raidplanner.entity.MyCharacter;
import cz.uhk.raidplanner.entity.Role;
import cz.uhk.raidplanner.entity.User;
import cz.uhk.raidplanner.repository.EquipmentRepository;
import cz.uhk.raidplanner.repository.MyCharacterRepository;
import cz.uhk.raidplanner.repository.RoleRepository;
import cz.uhk.raidplanner.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private MyCharacterRepository myCharacterRepository;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setLogin("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleUser); roles.add(roleAdmin);
		userAdmin.setRoles(roles);
		userAdmin.setPassword("admin");
		userRepository.save(userAdmin);
		
		MyCharacter char1 = new MyCharacter();
		char1.setName("Hlavní postavièka");
		char1.setCharClass("Gunslinger");
		char1.setUser(userAdmin);
		myCharacterRepository.save(char1);
		
		Equipment eq1 = new Equipment();
		eq1.setChest("Gunslingerùv kabát");
		eq1.setMainhand("Blasterová pistole");
		equipmentRepository.save(eq1);
		
		
		
	}
}
