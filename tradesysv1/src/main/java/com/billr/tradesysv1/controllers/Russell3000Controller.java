package com.billr.tradesysv1.controllers;

import java.util.ArrayList;

//import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.billr.tradesysv1.models.Position;
import com.billr.tradesysv1.models.Russell3000;
import com.billr.tradesysv1.repository.AccountRepository;
import com.billr.tradesysv1.repository.Russell3000Repository;


@Controller
public class Russell3000Controller {

	private Russell3000Repository russell3000Repository;

	@Autowired
	public Russell3000Controller(Russell3000Repository russell3000Repository) {
		this.russell3000Repository = russell3000Repository;
	}
	
	// Added this method to provide a hook for testing
	public Russell3000Repository getRussell3000Repository() {
		return this.russell3000Repository;
	}

	@GetMapping("/russell")
	public String showRussellPage(Model model) {
		
		
		Iterable<Russell3000> allRussell = russell3000Repository.findAll();
			
		model.addAttribute("allRussell", allRussell);
		return "russell";
	}

}