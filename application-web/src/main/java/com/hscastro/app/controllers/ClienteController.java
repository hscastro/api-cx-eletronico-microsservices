package com.hscastro.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hscastro.app.entities.Cliente;
import com.hscastro.app.feignClients.ClienteFeignClient;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteFeignClient repoFeignClient;
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		 return repoFeignClient.save(cliente);
	}
	
	@GetMapping(value = "/{id}")	
	public ResponseEntity<Cliente> findById(@PathVariable Long id){	
		
		Cliente objCliente = repoFeignClient.findById(id).getBody();
		return ResponseEntity.ok(objCliente);		
	}	
	
	@GetMapping	
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> lista = repoFeignClient.findAll();
		return ResponseEntity.ok(lista);		
	}	
}
