package com.billr.tradesysv1.controllers;

import java.util.ArrayList;

//import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.billr.tradesysv1.alpacaapi.Alpac;
import com.billr.tradesysv1.models.Position;
import com.billr.tradesysv1.repository.PositionRepository;
import com.billr.tradesysv1.repository.TradeRepository;


@Controller
public class PositionController {

	private PositionRepository positionRepository;

	@Autowired
	public PositionController(PositionRepository positionRepository) {
		this.positionRepository = positionRepository;
	}

	//************************************************
	// ENTRY POINT...  we want this to show  on login
	//************************************************
	@GetMapping("/position")
	public String showPositionPage(Model model) {
		
		positionServiceApiCall();
		
		if (!model.containsAttribute("position")) {
			model.addAttribute("position", new Position());
		}
		Iterable<Position> allPositions = positionRepository.findAllByOrderBySymbolAsc();
			
		model.addAttribute("allPositions", allPositions);
		return "positions";
	}

	public void positionServiceApiCall() {
	
		Alpac ap = new Alpac();
		System.out.println("OK1");
				
	 	ArrayList<Position> positions; 
		positions = ap.getPositions();
		
		//positions.sort((h1, h2) -> h1.getSymbol().compareTo(h2.getSymbol()));
	  
		// clean out the table for the refresh from API
	 	positionRepository.deleteAll();
	 	   
        for (int counter = 0; counter < positions.size(); counter++) { 	
      	   Position pos = positions.get(counter); 
      	   positionRepository.save(pos);
//      	   System.out.println("ASSETID=="+pos.getAsset_id());
//      	   System.out.println("SYMBOL =="+pos.getSymbol());
//      	   System.out.println("POS    =="+pos.getQty());
         }   
        
    }
}