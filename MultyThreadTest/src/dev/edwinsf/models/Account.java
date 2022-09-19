package dev.edwinsf.models;

public class Account {
	
	String name;
	Long amount = 0L;
	
	public Account() {
		
	}
	
	public Account(String name, Long amount) {
		this.name = name; 
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public void addAmount(long amount) {
		this.amount += amount;
	}
	
	public String toString() {
		return name + ": " + amount;
	}
	
}
