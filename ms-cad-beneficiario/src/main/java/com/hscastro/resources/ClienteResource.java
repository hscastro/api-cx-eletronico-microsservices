package com.hscastro.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PutMapping
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
		Cliente objCliente = service.save(cliente);
		return ResponseEntity.ok(objCliente);
	}
	
	
	@GetMapping(value = "/{id}")	
	public Cliente findById(@PathVariable Long id){			
		Cliente cliente = service.findById(id);
		return  cliente;		
	}	
	
//	@GetMapping(value = "/{name}")	
//	public ResponseEntity<List<Cliente>> findByName(@RequestBody String name){
//		List<Cliente> listClientes = service.findByName(name);
//		return ResponseEntity.ok().body(listClientes);
//	}
	
//	@GetMapping(value = "/{cpf}")	
//	public ResponseEntity<Cliente> findByCpf(@PathVariable("cpf") String cpf){
//		Cliente objCliente = service.findByCpf(cpf);
//		return ResponseEntity.ok(objCliente);
//	}	
	
	@GetMapping	
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> lista = service.findAll();
		return ResponseEntity.ok(lista);		
	}
	
//	@GetMapping("/excluir/{id}")
//	public String delete(@PathVariable("id") Long id) {
//		String delete = service.delete(id);
//		return delete;
//	}	
	
}
