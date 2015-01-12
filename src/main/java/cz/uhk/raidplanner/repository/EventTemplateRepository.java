package cz.uhk.raidplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.raidplanner.entity.EventTemplate;

public interface EventTemplateRepository extends JpaRepository<EventTemplate, Integer> {

}
