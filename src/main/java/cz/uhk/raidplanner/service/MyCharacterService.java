package cz.uhk.raidplanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import cz.uhk.raidplanner.entity.MyCharacter;
import cz.uhk.raidplanner.entity.User;
import cz.uhk.raidplanner.repository.MyCharacterRepository;
import cz.uhk.raidplanner.repository.UserRepository;

@Service
public class MyCharacterService {
	
	@Autowired
	MyCharacterRepository myCharacterRepository;
	
	@Autowired
	UserRepository userRepository;

	public void save(MyCharacter myCharacter, String login) {
		User user = userRepository.findByLogin(login);
		myCharacter.setUser(user);
		myCharacterRepository.save(myCharacter);
	}

	@PreAuthorize("#myCharacter.user.login == authentication.name OR hasRole('ROLE_ADMIN')")
	public void delete(@P("myCharacter") MyCharacter myCharacter) {
		myCharacterRepository.delete(myCharacter);
		
	}

	public MyCharacter findOne(int id) {
		return myCharacterRepository.findOne(id);
	}

	
	
}
