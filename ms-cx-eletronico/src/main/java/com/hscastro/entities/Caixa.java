package com.hscastro.entities;

public class Caixa {
	
	private String name;
	private Double amount;
	private Integer months;
	
	public Caixa() {
		// TODO Auto-generated constructor stub
	}

	public Caixa(String name, Double amount, Integer months) {		
		this.name = name;
		this.amount = amount;
		this.months = months;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}
	
	public double getTotal() {
		return amount / months; 
	}

}
