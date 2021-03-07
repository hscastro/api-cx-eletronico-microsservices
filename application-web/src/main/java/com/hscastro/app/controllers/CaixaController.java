package com.hscastro.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hscastro.app.entities.Cliente;
import com.hscastro.app.feignClients.CaixaEletronicoFeignClient;

@Controller
@RequestMapping("/caixas")
public class CaixaController {
	
	@Autowired
	private CaixaEletronicoFeignClient serviceCaixaFeignClient;


	@RequestMapping(method = RequestMethod.GET, value = "/cadastro")
	public String cadastrar() {
		return "caixas/cadastro";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/lista")
	public String lista() {
		return "caixas/lista";
	}	
	
	@GetMapping	
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> lista = serviceCaixaFeignClient.findAll();
		return ResponseEntity.ok(lista);		
	}	
	
}