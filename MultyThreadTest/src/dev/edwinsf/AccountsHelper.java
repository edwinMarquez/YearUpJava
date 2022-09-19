package dev.edwinsf;

import dev.edwinsf.models.Account;

public class AccountsHelper {


	public static void addBalance(Account acc, long balance) {

//		synchronized (acc) {
			acc.addAmount(balance);
//		}
	}

	public static void transfer(Account from, Account to, long balance) {

//		synchronized (from) {
//			synchronized (to) {
				long availableBalance = from.getAmount();
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (availableBalance >= balance) {
					from.addAmount(-balance);
					to.addAmount(balance);
					System.out.println("::log:: from: " + from.getName() + " to: " + to.getName()+ " tranfered: " + balance);
				}else {
					System.out.println("::log:: failed from: " +from.getName() + "to: " + to.getName());
				}
//			}
//		}
	}

}
