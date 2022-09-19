package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.edwinsf.AccountsHelper;
import dev.edwinsf.models.Account;

class AccountsHelperTest {

	Account fredAcc;
	Account albertAcc;
	
	@BeforeEach
	void initEach() {
		fredAcc = new Account("Fred", 200L);
		albertAcc = new Account("Albert", 200L);
	}
	
	@Test
	void testAddBalance() {
		AccountsHelper.addBalance(fredAcc, 200);
		Assertions.assertEquals(fredAcc.getAmount(), 400L);
	}
	
	
	@Test
	void testTransferBalance() {
		AccountsHelper.transfer(fredAcc, albertAcc, 100);
		Assertions.assertEquals(fredAcc.getAmount(), 100L);
		Assertions.assertEquals(albertAcc.getAmount(), 300L);
	}

}
