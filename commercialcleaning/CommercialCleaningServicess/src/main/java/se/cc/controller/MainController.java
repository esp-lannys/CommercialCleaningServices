package se.cc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String loadIndex(Model model) {
		return "index";
	}

	@GetMapping("/howitwork")
	public String loadDetail(Model model) {
		return "howitworks";
	}

	@GetMapping("/contact")
	public String loadContact(Model model) {
		return "contact";
	}

	@GetMapping("/about")
	public String loadAbout(Model model) {
		return "about";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	@GetMapping("/signup")
	public String signup(Model model) {
		return "signup";
	}
}
