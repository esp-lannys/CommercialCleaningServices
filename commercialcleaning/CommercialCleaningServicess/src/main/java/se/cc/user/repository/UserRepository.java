package se.cc.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import se.cc.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long>{
	
	User findById(long id);
	User findByEmail(String email);
	User findByUsername(String username);
	
}
