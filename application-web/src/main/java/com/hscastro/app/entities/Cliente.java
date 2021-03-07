package com.hscastro.app.entities;


public class Cliente {
	
	private Long id;		
	private String name;		
	private String cpf;		
	private String email;	
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
