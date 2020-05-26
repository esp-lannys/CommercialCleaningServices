package se.cc.user.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.cc.user.model.Role;
import se.cc.user.model.User;
import se.cc.user.repository.ContractRepository;
import se.cc.user.repository.RoleRepository;
import se.cc.user.repository.UserRepository;
import se.cc.user.webdto.AdminDto;
import se.cc.user.webdto.AdminUpdateInfoUserDto;
import se.cc.user.webdto.UserDto;
import se.cc.user.webdto.UserUpdateInfoDto;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private RoleRepository rolerepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private ContractRepository contractrepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}

	@Override
	public List<Role> findAllRole() {
		return rolerepository.findAll();
	}

	@Override
	public User findById(long id) {
		return userRepository.findById(id);
	}

	@Override
	public Role findByRole(long id) {
		// TODO Auto-generated method stub
		return rolerepository.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public User save(UserDto userdto) {
		User user = new User();
		user.setFirstname(userdto.getFirstname());
		user.setLastname(userdto.getLastname());
		user.setEmail(userdto.getEmail());
		user.setUsername(userdto.getUsername());
		user.setPassword(passwordEncoder.encode(userdto.getPassword())); 
		user.setBirthday(userdto.getBirthday());
		user.setPower(userdto.getPower());
		HashSet<Role> roles = new HashSet<>();
		roles.add(rolerepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		return userRepository.save(user);
	}

	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
	
	@Override
	public void autoLogin(String username) {
		UserDetails userDetails = loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, userDetails.getPassword(), userDetails.getAuthorities());

		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
	}

	
	@Override
	public AdminUpdateInfoUserDto save(User user) {
		AdminUpdateInfoUserDto auiu = new AdminUpdateInfoUserDto();
		auiu.setId(user.getUserid());
		auiu.setLastname(user.getLastname());
		auiu.setEmail(user.getEmail());
		auiu.setPassword(user.getPassword());
		auiu.setFirstname(user.getFirstname());
		auiu.setConfirmpassword(user.getPassword());
		auiu.setUsername(user.getUsername());
		auiu.setBirthday(user.getBirthday());
		auiu.setPower(user.getPower());
		switch (user.getPower()) {
		case 1:
			auiu.setDropdownSelectedValue("USER");
			break;
		case 2:
			auiu.setDropdownSelectedValue("ADMIN");
			;
			break;
		}
		return auiu;
	}

	@Override
	public UserUpdateInfoDto updateInfo(User p) {
		UserUpdateInfoDto us = new UserUpdateInfoDto();
		us.setId(p.getUserid());
		us.setFirstname(p.getFirstname());
		us.setLastname(p.getLastname());
		us.setBirthday(p.getBirthday());
		us.setEmail(p.getEmail());
		us.setUsername(p.getUsername());
		us.setPassword(p.getPassword());
		us.setConfirmpassword(p.getPassword());
		us.setPower(p.getPower());
		us.setRoles(p.getRoles());
		return us;
	}

	@Override
	public User save(AdminUpdateInfoUserDto userdto) {
		User user = new User();
		user.setFirstname(userdto.getFirstname());
		user.setLastname(userdto.getLastname());
		user.setEmail(userdto.getEmail());
		user.setUsername(userdto.getUsername());
		user.setPassword(passwordEncoder.encode(userdto.getPassword())); 
		user.setBirthday(userdto.getBirthday());
		user.setPower(userdto.getPower());
		String key = "ROLE_" + userdto.getDropdownSelectedValue();
		switch (key) {
		case "ROLE_USER":
			user.setPower(1);
			break;
		case "ROLE_ADMIN":
			user.setPower(2);
			break;
		}
		user.setUpdate_date(userdto.getUpdate_date());
		HashSet<Role> roles = new HashSet<>();
		roles.add(rolerepository.findByName(key));
		user.setRoles(roles);
		return userRepository.save(user);
	}
	
	@Override
	public User save(AdminDto userdto) {
		User user = new User();
		user.setFirstname(userdto.getFirstname());
		user.setLastname(userdto.getLastname());
		user.setEmail(userdto.getEmail());
		user.setUsername(userdto.getUsername());
		user.setPassword(passwordEncoder.encode(userdto.getPassword())); 
		user.setBirthday(userdto.getBirthday());
		user.setPower(userdto.getPower());
		String key = "ROLE_"+userdto.getDropdownSelectedValue();
		switch (key) {
		case "ROLE_USER":
			user.setPower(1);
			break;
		case "ROLE_ADMIN":
			user.setPower(2);
			break;
		}
		HashSet<Role> roles = new HashSet<>();
		roles.add(rolerepository.findByName(key));
		user.setRoles(roles);
		return userRepository.save(user);
	}

	public boolean checkExist(String username) {
		
		return false;
	}

}
