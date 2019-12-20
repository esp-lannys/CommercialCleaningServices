package se.cc.user.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import se.cc.user.model.User;
import se.cc.user.service.UserService;
import se.cc.user.webdto.AdminDto;
import se.cc.user.webdto.UserDto;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"/"})
	public String root(Authentication authentication, ModelMap map, Model model,
			HttpServletRequest request, Principal principal) {
		if(principal == null) {
			
		}else {
			
		}
		
		if (authentication != null) {
			Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
			List<String> roles = new ArrayList<String>();
			for (GrantedAuthority a : authorities) {
				roles.add(a.getAuthority());
			}
			if (isUser(roles)) {
				model.addAttribute("user", new UserDto());
			} else if (isAdmin(roles)) {
				model.addAttribute("admin", new AdminDto());
			}
			
		} else {
			map.addAttribute("ok", "FALSE");
		}
		return "index";
	}
	
	@PreAuthorize("!(hasRole('USER') OR hasRole('ADMIN'))")
	@GetMapping("/login")
	public String login(Model model,ModelMap map) {
		
		return "login";
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user")
	public String userPage(ModelMap map,Model model) {
		map.addAttribute("header", "header_user");
		model.addAttribute("user", new UserDto());
		return "/user";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String getAdmin(ModelMap map,Model model) {
		model.addAttribute("admin", new AdminDto());
		map.addAttribute("user", getPrincipal());
		return "/admin";
	}
	
	@GetMapping(value = "/403")
	public String accessDeniedPage(Authentication authentication, ModelMap map, Model model) {
		if (authentication != null) {
			Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
			List<String> roles = new ArrayList<String>();
			for (GrantedAuthority a : authorities) {
				roles.add(a.getAuthority());
			}

			if (isUser(roles)) {
				map.addAttribute("header", "header_user");
			} else if (isAdmin(roles)) {
				map.addAttribute("header", "header_admin");
			}
		} else {
			//
		}
		return "403";
}
	
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	private boolean isUser(List<String> roles) {
		if (roles.contains("ROLE_USER")) {
			return true;
		}
		return false;
	}

	private boolean isAdmin(List<String> roles) {
		if (roles.contains("ROLE_ADMIN")) {
			return true;
		}
		return false;
	}
}
