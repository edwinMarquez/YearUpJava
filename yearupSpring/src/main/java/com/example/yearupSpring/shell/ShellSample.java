package com.example.yearupSpring.shell;

import com.example.yearupSpring.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@ShellComponent
public class ShellSample {

	@Autowired
	UserRepository userRepo;
	@Autowired
	AccountRepository accountRepo;
	@Autowired
	TransactionRepository transactionRepo;

	@ShellMethod
	public String querydb() {
		List<User> users = userRepo.findAll();
		List<Account> accounts = accountRepo.findAll();
		List<Transaction> transactions = transactionRepo.findAll();

		StringBuilder infSB = new StringBuilder();
		infSB.append(Arrays.toString(users.toArray()));
		infSB.append("\n");
		infSB.append(Arrays.toString(accounts.toArray()));
		infSB.append("\n");
		infSB.append(Arrays.toString(transactions.toArray()));

		return infSB.toString();
	}

	@ShellMethod
	@Transactional
	public String transfer(int fromAccount, int toAccount, int amount){
		if(amount < 0) return "Transfers only allow for amounts > 0";
		try {

			Account fromAcc = accountRepo.findById(fromAccount).get();
			Account toAcc = accountRepo.findById(toAccount).get();

			if(fromAcc.getBalance() < amount)return "not enough balance";

			fromAcc.setBalance(fromAcc.getBalance() - amount);
			toAcc.setBalance(toAcc.getBalance() + amount);

			Transaction transactionFrom = new Transaction();
			transactionFrom.setUser(fromAcc.getUser());
			transactionFrom.setAmount(amount);
			transactionFrom.setTransactionTime(System.currentTimeMillis());

			Transaction transactionTo = new Transaction();
			transactionTo.setUser(toAcc.getUser());
			transactionTo.setAmount(- amount);
			transactionTo.setTransactionTime(System.currentTimeMillis());


			accountRepo.save(fromAcc);
			accountRepo.save(toAcc);
			transactionRepo.save(transactionFrom);
			transactionRepo.save(transactionTo);

		}catch (Exception e){
			return "NULL";
		}
		return "Ok";
	}
	
	
	
	
}
