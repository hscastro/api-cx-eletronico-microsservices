package com.hscastro.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_clientes")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "cpf", nullable = false, unique = true, length = 11)
	private String cpf;
	
	@Column(name = "email", nullable = false, length = 255)
	private String email;
	
	@Column(name = "vlr_total")
	private Double vlrTotal; 	

	@Column(name = "qtd_anos")
	private Integer qtdAnos;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	  

	public Cliente(Long id, String nome, String cpf, String email, Double vlrTotal, Integer qtdAnos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.vlrTotal = vlrTotal;
		this.qtdAnos = qtdAnos;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(Double vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

    
	public Integer getQtdAnos() {
		return qtdAnos;
	}


	public void setQtdAnos(Integer qtdAnos) {
		this.qtdAnos = qtdAnos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
