package com.billr.tradesysv1.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import com.billr.tradesysv1.models.Russell3000;
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

//	@GetMapping("/russell")
//	public String showRussellPage(Model model) {
//		
//		
//		Iterable<Russell3000> allRussell = russell3000Repository.findAll();
//			
//		model.addAttribute("allRussell", allRussell);
//		return "russell";
//	}

	@GetMapping("/russell")
	public String showRussellPage(HttpServletRequest request, ModelMap modelMap) {
		List<Russell3000> russell = (List<Russell3000>) russell3000Repository.findAll();
		PagedListHolder pagedListHolder = new PagedListHolder(russell);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(14);
		modelMap.put("pagedListHolder", pagedListHolder);
		return "russell/index";
	}
	
	
}