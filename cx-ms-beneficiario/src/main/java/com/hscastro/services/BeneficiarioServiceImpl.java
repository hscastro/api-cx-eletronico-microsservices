package com.hscastro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hscastro.entities.Beneficiario;
import com.hscastro.repositories.BeneficiarioRepository;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {
	
	
	@Autowired
	private BeneficiarioRepository repository;

	@Override
	public Beneficiario save(Beneficiario beneficiario) {
		return repository.save(beneficiario);
	}

	@Override
	public Optional<Beneficiario> findById(Long id) {
		Optional<Beneficiario> optionalBeneficiario = repository.findById(id);
		return optionalBeneficiario;
	}

	@Override
	public List<Beneficiario> findAll() {
		return repository.findAll();
	}


}
