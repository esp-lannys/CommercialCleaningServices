package se.cc.user.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import se.cc.user.model.*;
import se.cc.user.webdto.UserDto;


public interface UserService extends UserDetailsService{
	List<Role> findAllRole();
	
	User findById(long id);
	
	Role findByRole(long id);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	User save(UserDto userdto);
	
	List<User> findAllUser();
	
	void autoLogin(User user);
}
