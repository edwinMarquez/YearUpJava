package com.example.yearupSpring;


import com.example.yearupSpring.models.Account;

public class Client implements Runnable{

	Account from;
	Account to; 
	long balance;
	
	public Client(Account from, Account to, long balance) {
		this.from = from; 
		this.balance = balance; 
		this.to = to;
	}
	
	@Override
	public void run() {
		AccountsHelper.transfer(from, to, balance);
	}

}
