package com.billr.tradesysv1.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.billr.tradesysv1.alpacaapi.Alpac;
import com.billr.tradesysv1.models.Quote;
import com.billr.tradesysv1.models.QuoteFlattened;


@Controller
public class QuoteController {

	private HashMap<String,Quote> quoteCollection = new HashMap<String,Quote>();
	
	public HashMap<String, Quote> getQuoteCollection() {
		return quoteCollection;
	}
	
	public void setQuoteCollection(HashMap<String, Quote> quoteCollection) {
		this.quoteCollection = quoteCollection;
	}
	
	public QuoteController() {
		System.out.println("CONSTRUCTOR Quotes in Cache="+ quoteCollection.size());
	}
	
	@PostMapping("/quoteform/update")
	public String insertQuote(Model model,@ModelAttribute("quote") Quote qte) {
		
		Alpac ap = new Alpac();
		System.out.println("OK1");
		Quote nq = new Quote();
		nq = ap.getQuote(qte.getSymbol().toUpperCase());
		
		try {
			System.out.println("Quote="+nq.getSymbol()+" bid="+nq.getLast().getBidprice());
			System.out.println("TS    ="+nq.getLast().getTimestamp());
	    } catch (Exception e) {
	        System.out.println("Quote retrieve. Something went wrong!!!!");
	        return "redirect:/quoteEntryerror";
	    }
							
		this.add(nq);
					
		return "redirect:/quotecache";
	}
	
	
	@GetMapping("/quoteEntryerror")
	public String tradeEntryError(Model model) {	
		String emsg = "Stock Symbol is Not Found";
		model.addAttribute("emsg", emsg);
		return "qte_error";
		
	}
	
	public ArrayList getCachedSymbols()
	{
		ArrayList<String> symbols = new ArrayList<String>();
		Iterator hmIterator = quoteCollection.entrySet().iterator();
	    while (hmIterator.hasNext()) {
	    	Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
	        Quote qt = (Quote)mapElement.getValue();
	        //System.out.println(	qt.getSymbol());
	        symbols.add(qt.getSymbol());
	    }
		return symbols;
	}
	
	@GetMapping("/quotecache")	
	public String showCache(Model model) {
		
		System.out.println("Quotes in Cache="+ quoteCollection.size());
		
		if(quoteCollection.size() > 0 ) {
			System.out.println("REFRESH QUOTE CACHE");	
			ArrayList tmp = getCachedSymbols();
			for(int i=0; i < tmp.size(); i++) {
				Alpac ap = new Alpac();
				System.out.println("OK1");
				Quote nq = new Quote(); 
				nq = ap.getQuote(tmp.get(i).toString());	
				System.out.println("Quote="+nq.getSymbol()+" bid="+nq.getLast().getBidprice());
				System.out.println("TS    ="+nq.getLast().getTimestamp());	
				this.add(nq);
			}
		}
		
		List<QuoteFlattened> quotelist = new ArrayList<QuoteFlattened>();
				
		Iterator hmIterator = quoteCollection.entrySet().iterator();
	    while (hmIterator.hasNext()) {
	    	Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
	        Quote qt = (Quote)mapElement.getValue();
	        System.out.println(	qt.getSymbol()+" : "+qt.getLast().getBidprice()+" : "
	        +qt.getLast().getAskprice());
	        
	        QuoteFlattened qflat = new QuoteFlattened();
	        qflat.setSymbol(qt.getSymbol());
	        qflat.setAskprice(qt.getLast().getAskprice());
	        qflat.setBidprice(qt.getLast().getBidprice());
	        qflat.setAsksize(qt.getLast().getAsksize());
	        qflat.setBidsize(qt.getLast().getBidsize());
	        qflat.setqDate(qt.getLast().getTimestamp());
	        quotelist.add(qflat);
	    }
	    
		if (!model.containsAttribute("")) {
			model.addAttribute("quote", new Quote());
		}
					
		model.addAttribute("quotelist", quotelist);
		return "quote";
	}
	    
	public void add(Quote qte) {
		
		 if (quoteCollection.containsKey(qte.getSymbol())){
		     quoteCollection.remove(qte.getSymbol());
		 }
		 
		 quoteCollection.put(qte.getSymbol(), qte);
	}

	@GetMapping("/quoteform/{symbol}")
	public String showQuoteForm(Model model,@PathVariable("symbol") String symbol) {
		Quote qte = new Quote();
		System.out.println("quoteform SYMBOL="+symbol);
		qte.setSymbol(symbol);
		model.addAttribute("qte", qte);
		return "quoteentry";
	}

}
