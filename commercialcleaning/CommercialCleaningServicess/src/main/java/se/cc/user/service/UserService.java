package se.cc.user.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

import se.cc.user.webdto.UserUpdateInfoDto;
import se.cc.user.model.*;
import se.cc.user.webdto.AdminDto;
import se.cc.user.webdto.AdminUpdateInfoUserDto;
import se.cc.user.webdto.ContractDto;
import se.cc.user.webdto.UserDto;


public interface UserService extends UserDetailsService{
	List<Role> findAllRole();
	
	User findById(long id);
	
	Role findByRole(long id);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	User save(UserDto userdto);
	
	User save(AdminDto admindto);
	
	User save(AdminUpdateInfoUserDto admindto);
	
	AdminUpdateInfoUserDto save(User user);
	
	UserUpdateInfoDto updateInfo(User p);
	
	List<User> findAllUser();
	
	void autoLogin(String username);
}
