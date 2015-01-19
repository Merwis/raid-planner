package cz.uhk.raidplanner.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.raidplanner.entity.Actuality;

public interface ActualityRepository extends JpaRepository<Actuality, Integer> {

	List<Actuality> findAllByOrderByPublishedDesc(Pageable pageable);

}
