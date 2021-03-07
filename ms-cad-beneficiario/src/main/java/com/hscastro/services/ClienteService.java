package com.hscastro.services;

import java.util.List;

import com.hscastro.entities.Cliente;

public interface ClienteService {
	Cliente save(Cliente cliente);
	Cliente findById(Long id);
	//List<Cliente> findByName(String nome);
	//Cliente findByCpf(String cpf);
	Cliente update(Cliente cliente);
	//String delete(Long id);
	List<Cliente> findAll();		
}
