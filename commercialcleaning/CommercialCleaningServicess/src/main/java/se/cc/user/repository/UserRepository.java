package se.cc.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import se.cc.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long>{
	
	User findById(long id);
	User findByEmail(String email);
	User findByUsername(String username);
	
}
