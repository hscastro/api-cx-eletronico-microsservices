package com.hscastro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hscastro.entities.Caixa;
import com.hscastro.entities.Cliente;
import com.hscastro.feignClients.ClienteFeignClient;
import com.hscastro.services.CaixaEletronicotService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/eletronicos")
public class CaixaEletronicoController {
	
	@Autowired
	private CaixaEletronicotService service;	
	
	
	@Autowired
	private ClienteFeignClient feignCaixaRepository;
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		 return feignCaixaRepository.save(cliente);
	}
	
	@GetMapping(value = "/{id}")	
	public ResponseEntity<Cliente> findById(@PathVariable Long id){	
		
		Cliente objCliente = feignCaixaRepository.findById(id).getBody();
		return ResponseEntity.ok(objCliente);		
	}	

	
	@GetMapping	
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> lista = feignCaixaRepository.findAll();
		return ResponseEntity.ok(lista);		
	}
	
	//método faz o cálculo, passando o [ID] do cliente	
	@HystrixCommand(fallbackMethod = "getCalculoAposentadoriaAlternative")
	@GetMapping(value = "/{clienteId}/months/{months}")
	public ResponseEntity<Caixa> getCalculoAposentadoria(@PathVariable Long clienteId, 
			@PathVariable Integer months){
		Caixa calculo = service.getCalculoAposentadoria(clienteId, months);
		return ResponseEntity.ok(calculo);		
	}
	
	
	//método responde em caso de atrasos na requisição ou se não encontrar a rota definida
	public ResponseEntity<Caixa> getCalculoAposentadoriaAlternative(Long clienteId, Integer months){
		Caixa calculo = new Caixa("Fulano de Castro", 1100.00, months);
		return ResponseEntity.ok(calculo);		
	}	
}
