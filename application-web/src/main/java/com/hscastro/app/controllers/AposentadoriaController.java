package com.hscastro.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hscastro.app.entities.Cliente;
import com.hscastro.app.feignClients.CaixaEletronicoFeignClient;

@Controller
@RequestMapping("/aposentadorias")
public class AposentadoriaController {
	
	@Autowired
	private CaixaEletronicoFeignClient serviceCaixaFeignClient;


	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "/aposentadorias/cadastro";
	}
	
	@GetMapping("/lista")
	public String listar() {
		return "/aposentadorias/lista";
	}	
	
	@GetMapping	
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> lista = serviceCaixaFeignClient.findAll();
		return ResponseEntity.ok(lista);		
	}	
	
}