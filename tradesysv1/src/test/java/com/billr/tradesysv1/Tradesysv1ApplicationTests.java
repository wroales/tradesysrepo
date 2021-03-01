package com.billr.tradesysv1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.billr.tradesysv1.controllers.AccountController;
import com.billr.tradesysv1.controllers.Russell3000Controller;
import com.billr.tradesysv1.models.Account;
import com.billr.tradesysv1.models.Russell3000;
import com.billr.tradesysv1.models.SpringSession;
import com.billr.tradesysv1.repository.AccountRepository;
import com.billr.tradesysv1.repository.Russell3000Repository;
import com.billr.tradesysv1.services.CurrentUser;
import com.billr.tradesysv1.services.UserDetailsServiceImpl;


@SpringBootTest
class Tradesysv1ApplicationTests {

	private AccountController accountController;
	private UserDetailsServiceImpl userDetailsSvc;
	private Russell3000Controller russell3000Controller;
	
	@Autowired
	public Tradesysv1ApplicationTests( AccountController accountController,
			UserDetailsServiceImpl userDetailsSvc,
			Russell3000Controller russell3000Controller) {
		this.accountController = accountController;
		this.userDetailsSvc = userDetailsSvc;
		this.russell3000Controller = russell3000Controller;
	}
	
	@Test
	void contextLoads() {
		assertNotNull(accountController);
		assertNotNull(russell3000Controller);
		assertNotNull(userDetailsSvc);
	}
	
	// Use JUnit to perform unit and/or integration tests on
	// three custom query methods
	// 1. testAccount
	// 2. testRussell3000Content
	// 3. testUserDetailsServiceCurrentUser
	
	@Test
	void testAccount() {
		System.out.println("IN testAccount");
		
		AccountRepository ar = this.accountController.getAccountRepository();
		Iterable<Account> accounts = ar.findAll();
		Iterator<Account> iter = accounts.iterator();
	
		while(iter.hasNext()){
			Account tmp = iter.next();
			System.out.println("IN testAccount ASSERTING Account Number");
			assertEquals("PA3N7HNLLR3N",tmp.getAccount_number());
		}
		System.out.println("EXIT testAccount");
	}

	@Test
	void testRussell3000Content() {
		System.out.println("IN testRussell3000Content");
		
		Russell3000Repository ru = this.russell3000Controller.getRussell3000Repository();
		Iterable<Russell3000> allRussell = ru.findAll();
		Iterator<Russell3000> iter = allRussell.iterator();
	
		// Assert that this test symbol is in the russell 3000 list of stocks
		String assertSymbol="IBM";
		String symbol="";
		System.out.println("IN testRussell3000Content() ASSERTING symbol:"+assertSymbol);
		while(iter.hasNext()){
			Russell3000 tmp = iter.next();			
			if(tmp.getTkr().equals(assertSymbol)){
				symbol=tmp.getTkr();
			}
		}
		assertEquals(assertSymbol,symbol);
		System.out.println("EXIT testRussell3000Content");
	}
	
	
	@Test
	void testUserDetailsServiceCurrentUser() {
		UserDetails ud = userDetailsSvc.loadUserByUsername("testUser8");
		assertNotNull(ud);
		assertTrue(ud instanceof CurrentUser);
		assertEquals("testUser8", ud.getUsername());
	}
	
	@Test
	void testUserDetailsServiceUserNotFoundException() {
		assertThrows(UsernameNotFoundException.class, () -> {
			// Make sure "testUser10" does not exist in the database.
			userDetailsSvc.loadUserByUsername("testUserXX10");
		});
	}
}
