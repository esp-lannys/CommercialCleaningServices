package se.cc.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import se.cc.user.model.User;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String root() {
		
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		User user = new User();
		user.toString();
		return "login";
	}
	
	@GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}
