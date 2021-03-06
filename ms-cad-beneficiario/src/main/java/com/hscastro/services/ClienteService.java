package com.hscastro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;

import com.hscastro.entities.Cliente;

public interface ClienteService {
	Cliente save(Cliente cliente);
	Cliente findById(Long id);
	Cliente update(Cliente cliente);
	String delete(Long id);
	List<Cliente> findAll();		
}
