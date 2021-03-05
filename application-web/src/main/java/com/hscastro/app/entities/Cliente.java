package com.hscastro.app.entities;

import java.time.LocalDate;


public class Cliente {
	
	private Long id;
	
	
	private String name;
	
	
	private String cpf;
	
	
	private String email;
	
	@SuppressWarnings("unused")
	private LocalDate dataNascimento;	
	
	private String login;
	
	
	private String senha;	
	
	private Double vlrTotal; 	

	private Integer qtdAnos;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	  
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

}