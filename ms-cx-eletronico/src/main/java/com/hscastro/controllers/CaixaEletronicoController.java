package com.hscastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hscastro.entities.Caixa;
import com.hscastro.services.CaixaEletronicotService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/eletronicos")
public class CaixaEletronicoController {
	
	@Autowired
	private CaixaEletronicotService service;	

	@HystrixCommand(fallbackMethod = "getPayAposentadoriaAlternative")
	@GetMapping(value = "/{clienteId}/months/{months}")
	public ResponseEntity<Caixa> getPayAposentadoria(@PathVariable Long clienteId, 
			@PathVariable Integer months){
		Caixa pay = service.getPayAposentadoria(clienteId, months);
		return ResponseEntity.ok(pay);		
	}
	
	
	public ResponseEntity<Caixa> getPayAposentadoriaAlternative(Long clienteId, Integer months){
		Caixa pay = new Caixa("Fulano de Castro", 1100.00, months);
		return ResponseEntity.ok(pay);		
	}	
}
