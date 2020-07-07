package com.example.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicController {
	
	@RequestMapping("/")
	public ModelAndView init(ModelAndView model) {
		model.setViewName("menu");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getDetails());
		return model;
	}
	
	@GetMapping("/login")
	public ModelAndView getLogin(ModelAndView model) {
		System.out.println("login stared!");
		model.setViewName("login");
		return model;
	}
	
//	@RequestMapping(value = "/login/failed")
//	public ModelAndView error(@RequestParam("message") String message, ModelAndView model) {
//		model.addObject("msgLoginFailed", message);
//		model.setViewName("login");
//		return model;
//	}
	
	@RequestMapping(value = "/login/failed")
	public String error(@RequestParam("message") String message, Model model) {
		model.addAttribute("msgLoginFailed", message);
		return "login";
	}
	
	@GetMapping("/logoutsuccess")
	public ModelAndView Logout(ModelAndView model) {
		System.out.println("logout stared!");
		model.setViewName("logout");
		return model;
	}
	
	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/logoutsuccess";
	}
	
	@GetMapping("/menu")
	public ModelAndView showMenu(ModelAndView model) {
		model.setViewName("menu");
		return model;
	}
	
}
