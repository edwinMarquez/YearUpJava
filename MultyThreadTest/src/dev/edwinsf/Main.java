package dev.edwinsf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

import dev.edwinsf.models.Account;

public class Main {
	
	public static void main(String[] args) {
		
		
		Account tom = new Account("Tom", 10L);
		Account bob = new Account("Bob", 0L);
		
		Account tim = new Account("Tim", 100L);
		Account thor = new Account("Thor", 0L);
		
		System.out.println(tom);
		System.out.println(bob);
		System.out.println(tim); 
		System.out.println(thor);
		
//		AccountsHelper.transfer(tom, bob, 5);
//		
//		System.out.println(tom);
//		System.out.println(bob);
		
		//tom bob
		Thread t1 = new Thread(new Client(tom, bob, 5));
		Thread t2 = new Thread(new Client(tom, bob, 5));
		Thread t3 = new Thread(new Client(tom, bob, 5));
		Thread t4 = new Thread(new Client(tom, bob, 5));
		Thread t5 = new Thread(new Client(tom, bob, 5));
		Thread t6 = new Thread(new Client(tom, bob, 5));
		Thread t7 = new Thread(new Client(tom, bob, 5));
		Thread t8 = new Thread(new Client(tom, bob, 5));
		//tim thor
		Thread t9 = new Thread(new Client(tim, thor, 5));
		Thread t10 = new Thread(new Client(tim, thor, 5));
		Thread t11 = new Thread(new Client(tim, thor, 5));
		Thread t12 = new Thread(new Client(tim, thor, 5));
		Thread t13 = new Thread(new Client(tim, thor, 5));
		
		Long startTime = System.currentTimeMillis();
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		//------
		t9.start();
		t10.start();
		t11.start();
		t12.start();
		t13.start();
		
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
			t7.join();
			t8.join();
			t9.join();
			t10.join();
			t11.join();
			t12.join();
			t13.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		assert(false);
//		assert(tom.getAmount() >=0L);
//		assert(bob.getAmount() >= 0L);
//		assert(tim.getAmount() >= 0L);
//		assert(thor.getAmount() >= 0L);
		
		System.out.println("End result ts:" + (System.currentTimeMillis() - startTime) + "ms");
		System.out.println(tom);
		System.out.println(bob);
		System.out.println(tim); 
		System.out.println(thor);
		
	}
	

}
