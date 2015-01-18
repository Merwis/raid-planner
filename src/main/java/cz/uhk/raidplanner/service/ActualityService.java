package cz.uhk.raidplanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.raidplanner.entity.Actuality;
import cz.uhk.raidplanner.repository.ActualityRepository;

@Service
public class ActualityService {
	
	@Autowired
	ActualityRepository actualityRepository;

	public List<Actuality> findAll() {
		return actualityRepository.findAll();
	}

	public void save(Actuality actuality) {
		actualityRepository.save(actuality);
	}

	
	
}
