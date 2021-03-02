package com.hscastro.entities;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;	

	private Long id;
	private String name;	
	private Double amount; 	

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
    
	public Cliente(Long id, String name, Double amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
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
    
	public Double getVlrTotal() {
		return amount;
	}

	public void setVlrTotal(Double amount) {
		this.amount = amount;
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
