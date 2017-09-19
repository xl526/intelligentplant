package com.dp.intelligentplant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	@RequestMapping("/login")
	public String loginPage (HttpServletRequest request, Model model) {
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
	    	new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		return "redirect:/login?logout";
	}
	
	@RequestMapping("/admin")
	public String adminPage (HttpServletRequest request, Model model) {
		model.addAttribute("userName", getPrincipal());
		return "admin";
	}
	
	@RequestMapping("/access_denied")
	public String accessDeniedPage (HttpServletRequest request, Model model) {
		model.addAttribute("userName", getPrincipal());
		return "accessDenied";
	}
	
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	
}
