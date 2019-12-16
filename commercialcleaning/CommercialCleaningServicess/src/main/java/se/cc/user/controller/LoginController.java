package se.cc.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import se.cc.user.model.User;

@Controller
@RequestMapping("/login")
public class LoginController {

	
	@GetMapping
	public String showPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping
	public ModelAndView loginSuccess(@Valid @ModelAttribute ("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("login");
		}
		ModelAndView mav = new ModelAndView("index");
		
		return mav;
	}
}
