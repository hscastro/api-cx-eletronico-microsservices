package com.hscastro.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hscastro.entities.Cliente;

@Component
@FeignClient(name = "ms-cad-beneficiario", path = "/clientes")
public interface ClienteFeignClient {
	
	@GetMapping(value = "/{id}")	
	ResponseEntity<Cliente> findById(@PathVariable Long id);

}
