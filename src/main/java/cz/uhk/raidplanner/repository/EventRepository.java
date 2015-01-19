package cz.uhk.raidplanner.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.raidplanner.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

	List<Event> findAllByOrderByDateDesc(Pageable pageable);
}
