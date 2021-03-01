package com.hscastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hscastro.entities.Beneficiario;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

}
