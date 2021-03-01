package com.billr.tradesysv1.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.billr.tradesysv1.models.MktOrder;
import com.billr.tradesysv1.models.OrderStatus;
import com.billr.tradesysv1.models.Position;
import com.billr.tradesysv1.repository.OrderStatusRepository;


@Controller
public class OrderStatusController {

	private OrderStatusRepository orderStatusRepository;

	@Autowired
	public OrderStatusController(OrderStatusRepository orderStatusRepository) {
		this.orderStatusRepository = orderStatusRepository;
	}

	
//	@GetMapping("/")
//	public String showNavigation(Model model) {
//		
//		System.out.println("=====>> IN @GetMapping(\"/\")");
//		return "nav";
//	}
	
	
	@GetMapping("/orderstatus")
	public String showOrderStatusPage(Model model) {
		
		orderStatusServiceApiCall();
		
		if (!model.containsAttribute("orderstatus")) {
			model.addAttribute("orderstatus", new OrderStatus());
		}
		Iterable<OrderStatus> ordstatus = orderStatusRepository.findAll();
	
		model.addAttribute("ordstatus", ordstatus);
		return "orderstatus";
	}
		
	
	@PostMapping("/tradeform/update")
	public String insertTrade(Model model,@ModelAttribute("order") MktOrder mo) {
	
     	MktOrder ord = new MktOrder();
    	ord.setSide(mo.getSide());
    	ord.setQty(mo.getQty());
    	ord.setSymbol(mo.getSymbol());
    	ord.setType(mo.getType());
    	String px = mo.getLimit_price();
    	if(px.length() > 0 ) {
            ord.setLimit_price(px);;
    	}
    	ord.setTime_in_force("gtc");
		
		Alpac ap = new Alpac();
		boolean ok = ap.tradeEntry(ord);
		if(!ok) {
			System.out.println("TE Error****************************");
			System.out.println(ap.getTeError());
			System.out.println("TE Error****************************");	
			String err=ap.getTeError();
			String err1 = err.replace("{"," ");
			String err2 = err1.replace("}"," ");
			String err3 = err2.replace("\""," ");
			String err4 = err3.replace("\\"," ");
			return "redirect:/TradeEntryerror/"+err4;
		}
		
		// if limit order redirect to orderstatus, else position
		if(px.length() > 0 ) {
		    return "redirect:/orderstatus";
		}else {
			return "redirect:/position";
		}
		
	}
	
	@PostMapping("/cancel/update")
	public String updateOrder(Model model,@ModelAttribute("order") OrderStatus os) {
		
		Alpac ap = new Alpac();
		ap.tradeCancel(os.getId());
		
		//orderStatusRepository.save(os);
		return "redirect:/orderstatus";
		
	}
	
	@GetMapping("/tradeform/{symbol}")
	public String showTradeForm(Model model,@PathVariable("symbol") String symbol) {
		boolean inPosition = false;
		MktOrder order = new MktOrder();
		System.out.println("tradeform SYMBOL="+symbol);
		//=============================================
		// Handle a position close out from Position Page
		Alpac ap = new Alpac();
		System.out.println("OK1");
				
	 	ArrayList<Position> positions; 
		positions = ap.getPositions();
	 	   
		String qty="";
		String side="";
        for (int counter = 0; counter < positions.size(); counter++) { 	
      	   	Position pos = positions.get(counter); 
      	   	if(symbol.equals(pos.getSymbol())) {
      	   		inPosition=true;
      	   		System.out.println("SYMBOL =="+pos.getSymbol());
      	   		System.out.println("POS    =="+pos.getQty());
      	   		System.out.println("SIDE   =="+pos.getSide());
      	   		qty=pos.getQty();
      	   		side=pos.getSide();
      	   		break;
      	   	}
         }   
		
		//=============================================
		order.setSymbol(symbol);
		if(inPosition) {
			order.setQty(qty);
			if(side.equals("long")) {
				order.setSide("sell");
			}
		}
		model.addAttribute("order", order);
		return "tradeentry";
	}
	
	@GetMapping("/TradeEntryerror/{emsg}")
	public String tradeEntryError(Model model,@PathVariable("emsg") String emsg) {	
		System.out.println("IN ERROR msg="+emsg);
		model.addAttribute("emsg", emsg);
		return "te_error";
		
	}
	
	// Cancel an Order
	@GetMapping("/cancel/{id}")
	public String cancelOrder(Model model,@PathVariable("id") String id) {
		OrderStatus order = orderStatusRepository.findById(id).get();
		System.out.println("ORDER sym"+order.getSymbol());
		model.addAttribute("order", order);
		
		//return "redirect:/";

		return "CancelOrderForm";
	}
	
	public void orderStatusServiceApiCall() {
	
	 	orderStatusRepository.deleteAll();
	 	
		Alpac ap = new Alpac();
		System.out.println("OK1");
        ArrayList<OrderStatus> ordStats;
    try {
        	ordStats = ap.getOrderStatus();

        	//System.out.println("Orders On Tap="+ordStats.size());
    	
        	for (int counter = 0; counter < ordStats.size(); counter++) { 	
        		OrderStatus os = ordStats.get(counter);
        		orderStatusRepository.save(os);
//            	System.out.println("ID  ="+os.getId()); 
//            	System.out.println("SYM ="+os.getSymbol());
//            	System.out.println("FILL="+os.getFilled_at());
//            	System.out.println("TYPE="+os.getOrder_type());
//            	System.out.println("LMT ="+os.getLimit_price());
//            	System.out.println("STAT="+os.getStatus());           	
        	}
        
    	}catch(Exception ex) {
    		System.out.println("ERROR creating OrderStatus");
    		ex.printStackTrace();
    	}   
    		
    }
}