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
	private CaixaEletronicotService paymentService;	

	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Caixa> getPayment(@PathVariable Long workerId, 
			@PathVariable Integer days){
		Caixa payment = paymentService.getPayment(workerId, days);
		return ResponseEntity.ok(payment);		
	}
	
	
	public ResponseEntity<Caixa> getPaymentAlternative(Long workerId, Integer days){
		Caixa payment = new Caixa("Brann", 400.0, days);
		return ResponseEntity.ok(payment);		
	}	
}
