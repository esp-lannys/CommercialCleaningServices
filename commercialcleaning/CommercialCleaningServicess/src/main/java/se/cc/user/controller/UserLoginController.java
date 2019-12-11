package se.cc.user.controller;

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

import se.cc.user.model.User;
import se.cc.user.service.UserService;
import se.cc.user.webdto.UserDto;

@Controller
@RequestMapping("/signup")
public class UserLoginController {
	
	@Autowired
	private UserService userservice;
	
	@ModelAttribute("user")
	public UserDto userDto() {
		return new UserDto();
	}
	
	@GetMapping
	public String signup(Authentication authentication,Model model) {
		model.addAttribute("user", new UserDto());
		return "signup";
	}
	
	@PostMapping
	public String register(@ModelAttribute("user") @Valid UserDto userdto, BindingResult result) throws Exception {
		User existingUsername = userservice.findByUsername(userdto.getUsername());
		User existingEmail = userservice.findByEmail(userdto.getEmail());
		
		if (existingEmail != null || existingUsername != null) {
			result.rejectValue("email", null,"There is email or username already registered");
		}
		if (result.hasErrors()) {
			return "signup";
		}
		userservice.save(userdto);
		return "redirect:/index?success";
	}
}
