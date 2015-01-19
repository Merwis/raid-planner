package cz.uhk.raidplanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import cz.uhk.raidplanner.entity.Actuality;
import cz.uhk.raidplanner.repository.ActualityRepository;

@Service
public class ActualityService {
	
	@Autowired
	ActualityRepository actualityRepository;

	public List<Actuality> findAllByOrderByPublishedDesc() {
		return actualityRepository.findAllByOrderByPublishedDesc(new PageRequest(0, 5));
	}

	public void save(Actuality actuality) {
		actualityRepository.save(actuality);
	}

	public Actuality findOneById(int id) {
		return actualityRepository.findOne(id);
	}

	@PreAuthorize(value="hasRole('ROLE_ADMIN') OR hasRole('ROLE_OFFICER')")
	public void delete(int id) {
		actualityRepository.delete(id);
	}

	
	
}
