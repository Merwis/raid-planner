package cz.uhk.raidplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.raidplanner.entity.Actuality;

public interface ActualityRepository extends JpaRepository<Actuality, Integer> {

}
