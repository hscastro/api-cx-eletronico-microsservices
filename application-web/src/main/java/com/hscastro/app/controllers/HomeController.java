package com.hscastro.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hscastro.app.entities.Cliente;


@Controller
public class HomeController {
		
//	@GetMapping("/")
//	public String home() {		
//		return "home";
//	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home() {		
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login() {		
		return "login";
	}	
	
	
	
}
