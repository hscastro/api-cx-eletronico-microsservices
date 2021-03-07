package com.hscastro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hscastro.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
  
	List<Cliente> findByName(String name);
	Cliente findByCpf(String cpf);
}
