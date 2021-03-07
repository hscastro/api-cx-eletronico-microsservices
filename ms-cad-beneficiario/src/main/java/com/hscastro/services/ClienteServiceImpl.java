package com.hscastro.services;

import java.util.List;

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
		Cliente cliente = repository.findById(id).get();
		return cliente;
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

//	@Override
//	public String delete(Long id) {
//		repository.deleteById(id);
//		return "Delete";
//	}
//
//	@Override
//	public List<Cliente> findByName(String name) {
//		List<Cliente> listClientes = repository.findByName(name);
//		return listClientes;
//	}
//
//	@Override
//	public Cliente findByCpf(String cpf) {
//		Cliente cliente = repository.findByCpf(cpf);
//		return cliente;
//	}

}
