package com.billr.tradesysv1.controllers;

import java.util.ArrayList;
import java.util.Iterator;

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
import com.billr.tradesysv1.models.Trade;
import com.billr.tradesysv1.repository.TradeRepository;


@Controller
public class TradeController {

	private TradeRepository tradeRepository;

	@Autowired
	public TradeController(TradeRepository tradeRepository) {
		this.tradeRepository = tradeRepository;
	}

	@GetMapping("/trade")
	public String showTradePage(Model model) {
		
		tradeServiceApiCall();
		
		if (!model.containsAttribute("trade")) {
			model.addAttribute("trade", new Trade());
		}
		Iterable<Trade> allTrades = tradeRepository.findAll();
		
//		Iterator<Trade> iter = allTrades.iterator();
//		System.out.println("IN TRADE CONTROLLER");
//		while(iter.hasNext()){
//			System.out.println("TRADE="+iter.next());
//		}
		
		model.addAttribute("allTrades", allTrades);
		return "trades";
	}

	
	public void tradeServiceApiCall() {
	
		Alpac ap = new Alpac();
		System.out.println("OK1");
				
	 	ArrayList<Trade> trades; 
		trades = ap.getTrades();
	  
		// clean out the trade table for the refresh from API
	 	tradeRepository.deleteAll();
	 	
	    for (int counter = 0; counter < trades.size(); counter++) { 	
	 	   Trade trd = trades.get(counter); 
	 	   Trade savedTrade = tradeRepository.save(trd);
//	 	   System.out.println("===================================");
//	 	   System.out.println("TIME    =="+trd.getTransaction_time());
//	 	   System.out.println("ACT TYPE=="+trd.getActivity_type());
//	 	   System.out.println("ID      =="+trd.getId());
//	 	   System.out.println("ORDID   =="+trd.getOrder_id());
//	 	   System.out.println("SYM     =="+trd.getSymbol());
//	 	   System.out.println("PX      =="+trd.getPrice());
//	 	   System.out.println("QTY     =="+trd.getQty());
//	 	   System.out.println("LEAVES  =="+trd.getLeaves_qty());
//	 	   System.out.println("SIDE    =="+trd.getSide());
	 	   
	    }   

    }
}