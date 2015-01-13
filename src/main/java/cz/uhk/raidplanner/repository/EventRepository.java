package cz.uhk.raidplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.raidplanner.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
