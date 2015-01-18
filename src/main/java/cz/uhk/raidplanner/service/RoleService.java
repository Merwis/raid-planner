package cz.uhk.raidplanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.raidplanner.entity.Role;
import cz.uhk.raidplanner.repository.RoleRepository;

@Service
@Transactional
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	public Role findByName(String string) {		
		return roleRepository.findByName(string);
	}
	
	
}
