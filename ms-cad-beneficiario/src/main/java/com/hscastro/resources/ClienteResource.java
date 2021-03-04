package com.hscastro.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hscastro.entities.Cliente;
import com.hscastro.services.ClienteService;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
		
	@Autowired
	private ClienteService service;

	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		Cliente objCliente = service.save(cliente);
		return ResponseEntity.ok(objCliente);
	}
	
	@GetMapping(value = "/{id}")	
	public ResponseEntity<Cliente> findById(@PathVariable Long id){	
		
		Cliente objCliente = service.findById(id).get();
		return ResponseEntity.ok(objCliente);		
	}
	
	@GetMapping	
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> lista = service.findAll();
		return ResponseEntity.ok(lista);		
	}
	
}
