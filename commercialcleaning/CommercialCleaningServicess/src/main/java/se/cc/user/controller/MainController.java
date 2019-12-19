package se.cc.user.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	
	@GetMapping("/howitwork")
	public String loadDetail() {
		return "howitworks";
	}

	@GetMapping("/contact")
	public String loadContact() {
		return "contact";
	}

	@GetMapping("/about")
	public String loadAbout() {
		return "about";
	}
	
	@GetMapping("/service")
	public String loadService() {
		return "services";
	}
}
