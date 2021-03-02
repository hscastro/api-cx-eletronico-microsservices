package com.hscastro.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hscastro.entities.Caixa;
import com.hscastro.entities.Cliente;
import com.hscastro.feignClients.ClienteFeignClient;

@Service
public class CaixaEletronicotService {
	
	@Autowired
	private ClienteFeignClient service;
	
	public Caixa getPayAposentadoria(long clienteId, int months) {			
		Cliente cliente = service.findById(clienteId).getBody();		
		return new Caixa(cliente.getName(), cliente.getVlrTotal(), months);
	}
}
