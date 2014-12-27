package cz.uhk.raidplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.raidplanner.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
