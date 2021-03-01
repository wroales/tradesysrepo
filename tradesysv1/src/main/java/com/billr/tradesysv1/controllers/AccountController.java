package com.billr.tradesysv1.controllers;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.billr.tradesysv1.alpacaapi.Alpac;
import com.billr.tradesysv1.models.Account;
import com.billr.tradesysv1.repository.AccountRepository;

// account

@Controller
public class AccountController {

	private AccountRepository accountRepository;

	@Autowired
	public AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	// Added this method to provide a hook for testing
	public AccountRepository getAccountRepository() {
		return this.accountRepository;
	}
	
	@GetMapping("/account")
	public String showAccountPage(Model model) {
		
		accountServiceApiCall();
		
		if (!model.containsAttribute("account")) {
			model.addAttribute("account", new Account());
		}
		Iterable<Account> account = accountRepository.findAll();
		
//		Iterator<Account> iter = account.iterator();
//		System.out.println("IN ACCT CONTROLLER");
//		while(iter.hasNext()){
//			System.out.println("ACCT="+iter.next().getAccount_number());
//		}
		
		model.addAttribute("account", account);
		return "account";
	}

	
	public void accountServiceApiCall() {
	
		Alpac ap = new Alpac();
		System.out.println("OK1");
				
		Account acct = ap.getAcct();  
		// clean out the table for the refresh from API
	 	accountRepository.deleteAll();
	 	accountRepository.save(acct);
    }
}