package cz.uhk.raidplanner.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cz.uhk.raidplanner.entity.Equipment;
import cz.uhk.raidplanner.entity.EventTemplate;
import cz.uhk.raidplanner.entity.MyCharacter;
import cz.uhk.raidplanner.entity.Role;
import cz.uhk.raidplanner.entity.User;
import cz.uhk.raidplanner.repository.EquipmentRepository;
import cz.uhk.raidplanner.repository.EventTemplateRepository;
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
	
	@Autowired
	private EventTemplateRepository eventTemplateRepository;
	
	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		Role roleOfficer = new Role();
		roleOfficer.setName("ROLE_OFFICER");
		roleRepository.save(roleOfficer);
		
		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setLogin("admin");
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		userAdmin.setPassword(bc.encode("admin"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleUser); roles.add(roleAdmin); roles.add(roleOfficer);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Equipment eq1 = new Equipment();
		eq1.setChest("Gunslingerùv kabát");
		eq1.setMainhand("Blasterová pistole");
		equipmentRepository.save(eq1);
		
		MyCharacter char1 = new MyCharacter();
		char1.setName("Hlavní postavièka");
		char1.setCharClass("Gunslinger");
		char1.setUser(userAdmin);
		char1.setEquip(eq1);
		myCharacterRepository.save(char1);
		
		Equipment eq2 = new Equipment();
		eq2.setChest("Jediho župan");
		eq2.setMainhand("Svìtelný meè");
		equipmentRepository.save(eq2);
		
		MyCharacter char2 = new MyCharacter();
		char2.setName("Druhá postavièka");
		char2.setCharClass("Jedi Knight");
		char2.setUser(userAdmin);
		char2.setEquip(eq2);
		myCharacterRepository.save(char2);
		
		User userUser = new User();
		userUser.setEnabled(true);
		userUser.setLogin("test");
		userUser.setPassword(bc.encode("admin"));
		List<Role> roles1 = new ArrayList<Role>();
		roles1.add(roleUser); roles.add(roleOfficer);
		userUser.setRoles(roles1);
		userRepository.save(userUser);
		
		Equipment eq3 = new Equipment();
		eq3.setChest("Gunslingerùv kabát");
		eq3.setMainhand("Blasterová pistole");
		equipmentRepository.save(eq3);
		
		MyCharacter char3 = new MyCharacter();
		char3.setName("Hlavní postavièka 1");
		char3.setCharClass("Gunslinger");
		char3.setUser(userUser);
		char3.setEquip(eq3);
		myCharacterRepository.save(char3);
		
		Equipment eq4 = new Equipment();
		eq4.setChest("Jediho župan");
		eq4.setMainhand("Svìtelný meè");
		equipmentRepository.save(eq4);
		
		MyCharacter char4 = new MyCharacter();
		char4.setName("Druhá postavièka 1");
		char4.setCharClass("Jedi Knight");
		char4.setUser(userUser);
		char4.setEquip(eq4);
		myCharacterRepository.save(char4);
		
		EventTemplate et = new EventTemplate();
		et.setName("Eternity Vault");
		et.setMaxPlayers(8);
		et.setMinLvl(50);
		et.setNote("Popisek raidu");
		eventTemplateRepository.save(et);
		
		EventTemplate et1 = new EventTemplate();
		et1.setName("Karraga's Pallace");
		et1.setMaxPlayers(8);
		et1.setMinLvl(50);
		et1.setNote("Popisek raidu");
		eventTemplateRepository.save(et1);
		
		
		
		
	}
}
