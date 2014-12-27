package cz.uhk.raidplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.raidplanner.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
