package com.hscastro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hscastro.entities.Cliente;
import com.hscastro.messages.ClienteSendMessage;
import com.hscastro.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	
	private ClienteRepository repository;
	private ClienteSendMessage clienteSendMessage;
		
	@Autowired
	public ClienteServiceImpl(ClienteRepository repository, ClienteSendMessage clienteSendMessage) {
		this.repository = repository;
		this.clienteSendMessage = clienteSendMessage;
	}

	@Override
	public Cliente save(Cliente cliente) {
		//insere o cliente na fila do RabbitMQ
		this.clienteSendMessage.sendMessage(cliente);
		//salva e rotorna o cliente
		return repository.save(cliente);
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		Optional<Cliente> optionalBeneficiario = repository.findById(id);
		return optionalBeneficiario;
	}

	@Override
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Cliente> update(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}


}
