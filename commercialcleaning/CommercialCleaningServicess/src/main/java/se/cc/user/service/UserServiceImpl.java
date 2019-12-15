package se.cc.user.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.cc.user.model.Role;
import se.cc.user.model.User;
import se.cc.user.repository.RoleRepository;
import se.cc.user.repository.UserRepository;
import se.cc.user.webdto.UserDto;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private RoleRepository rolerepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
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
		user.setAge(userdto.getAge());
		user.setEmail(userdto.getEmail());
		user.setUsername(userdto.getUsername());
		user.setPassword(userdto.getPassword());
		user.setBirthday(userdto.getBirthday());
		return userRepository.save(user);
	}

	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

}
