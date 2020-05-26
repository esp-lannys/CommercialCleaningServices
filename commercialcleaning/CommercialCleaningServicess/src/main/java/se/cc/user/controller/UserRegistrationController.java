package se.cc.user.controller;

import java.security.Principal;
import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import se.cc.user.model.Role;
import se.cc.user.model.User;
import se.cc.user.service.UserService;
import se.cc.user.webdto.UserDto;

@Controller
public class UserRegistrationController {
	
	@Autowired
	private UserService userservice;
	
	@ModelAttribute("user")
	public UserDto userDto() {
		return new UserDto();
	}
	
	@GetMapping("/signup")
	public String signup(Authentication authentication,Model model) {
		model.addAttribute("user", new UserDto());
		return "signup";
	}
	
	@PostMapping("/signup/add")
	public String register(@ModelAttribute("user") @Valid UserDto userdto, 
			BindingResult result, 
			@RequestParam("username") String username,
			@RequestParam("email") String email,
			@RequestParam("password") String password) throws Exception {
		User existingUsername = userservice.findByUsername(userdto.getUsername());
		User existingEmail = userservice.findByEmail(userdto.getEmail());
		System.out.println(username + "|||user name");
		if (existingEmail != null || existingUsername != null) {
			result.rejectValue("email", null,"There is email or username already registered");
		}
		if (result.hasErrors()) {
			return "signup";
		}
		userservice.save(userdto);
//		User existingUsername = userservice.findByUsername(username);
//		User existingEmail = userservice.findByEmail(email);
//		UserDto newUser = new UserDto();
//		if (existingEmail != null || existingUsername != null) {
//			result.rejectValue("email", null,"There is email or username already registered");
//		} else {
//			System.out.println("Thanh cong");
//			newUser.setEmail(email);
//			newUser.setPassword(password);
//			newUser.setUsername(username);
//			newUser.setBirthday(null);
//			newUser.setConfirmpassword(password);
//			newUser.setFirstname("1");
//			newUser.setLastname("1");
//			newUser.setTerms(true);
//			HashSet<Role> roles = new HashSet<>();
//			roles.add(rolerepository.findByName(key));
//			newUser.setRoles(roles);
//			userservice.save(newUser);
//			return "redirect:/signup?success";
//		}
		if (result.hasErrors()) {
			return "signup";
		}
		return "redirect:/login";
	}
}
