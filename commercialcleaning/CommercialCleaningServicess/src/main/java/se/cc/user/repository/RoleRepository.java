package se.cc.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import se.cc.user.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>, CrudRepository<Role, Long>{
	Role findByName(String name);
	
	Role findById(long id);
}
