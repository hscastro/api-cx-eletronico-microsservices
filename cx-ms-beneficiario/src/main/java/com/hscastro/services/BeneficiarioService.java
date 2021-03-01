package com.hscastro.services;

import java.util.List;
import java.util.Optional;

import com.hscastro.entities.Beneficiario;

public interface BeneficiarioService {
	Beneficiario save(Beneficiario beneficiario);
	Optional<Beneficiario> findById(Long id);
	Optional<Beneficiario> update(Beneficiario beneficiario);
	List<Beneficiario> findAll();		
}
