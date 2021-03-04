package com.hscastro.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aposentadorias")
public class AposentadoriaController {


	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "/aposentadorias/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/aposentadorias/lista";
	}	
	
}