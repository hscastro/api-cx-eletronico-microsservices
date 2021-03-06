package com.hscastro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hscastro.entities.Cliente;
import com.hscastro.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	
	@Autowired
	private ClienteRepository repository;	
	
	//@Autowired
    //private ClienteSendMessage clienteSendMessage;
		

	@Override
	public Cliente save(Cliente cliente) {
		//salva e rotorna o cliente
		Cliente cli = repository.save(cliente);
		//insere o cliente na fila do RabbitMQ
		//clienteSendMessage.sendMessage(cliente);
		return cli; 
	}

	@Override
	public Cliente findById(Long id) {
		Cliente optionalBeneficiario = repository.findById(id).get();
		return optionalBeneficiario;
	}

	@Override
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	public Cliente update(Cliente cliente) {
		Cliente cli = repository.save(cliente);
		return cli;
	}

	@Override
	public String delete(Long id) {
		repository.deleteById(id);
		return "Delete";
	}

}
