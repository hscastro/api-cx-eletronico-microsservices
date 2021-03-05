package com.hscastro.app.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.hscastro.app.entities.Cliente;

@Component
@FeignClient(name = "ms-cx-eletronico", path = "/eletronicos")
public interface CaixaEletronicoFeignClient {
			
	@GetMapping(value = "/{id}")	
	ResponseEntity<Cliente> findById(@PathVariable Long id);

	@GetMapping(value = "/{cpf}")	
	ResponseEntity<Cliente> findByCpf(@PathVariable String cpf);
	
	@PostMapping
	ResponseEntity<Cliente> save(Cliente cliente);
	
	@GetMapping
	List<Cliente> findAll();
	
}
