package se.cc.user.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import se.cc.user.webdto.UserDto;

@Controller
public class MainController {

	
	@PreAuthorize("!(hasRole('EMPLOYEE') OR hasRole('ADMIN'))")
	@GetMapping("/howitwork")
	public String loadDetail(Model model, ModelMap map) {
		
		return "howitworks";
	}
	@PreAuthorize("!(hasRole('EMPLOYEE') OR hasRole('ADMIN'))")
	@GetMapping("/about")
	public String loadAbout(Model model, ModelMap map) {
		
		return "about";
	}
	@PreAuthorize("!(hasRole('EMPLOYEE') OR hasRole('ADMIN'))")
	@GetMapping("/service")
	public String loadService(Model model, ModelMap map) {
		return "services";
	}
	
	@PreAuthorize("!(hasRole('EMPLOYEE') OR hasRole('ADMIN'))")
	@GetMapping("/user/about")
	public String loadUserAbout(Model model, ModelMap map) {
		
		return "userAbout";
	}
	
	@PreAuthorize("!(hasRole('EMPLOYEE') OR hasRole('ADMIN'))")
	@GetMapping("/user/service")
	public String loadUserService(Model model, ModelMap map) {
		
		return "userServices";
	}
	@PreAuthorize("!(hasRole('EMPLOYEE') OR hasRole('ADMIN'))")
	@GetMapping("/user/howitwork")
	public String loadUserProcess(Model model, ModelMap map) {
		
		return "userHowitworks";
	}
}
