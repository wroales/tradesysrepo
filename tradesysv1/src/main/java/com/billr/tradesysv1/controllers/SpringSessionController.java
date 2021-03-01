package com.billr.tradesysv1.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.billr.tradesysv1.models.SessionDisplay;
import com.billr.tradesysv1.models.SpringSession;
import com.billr.tradesysv1.repository.SpringSessionRepository;


@Controller
public class SpringSessionController {

	private SpringSessionRepository springSessionRepository;

	@Autowired
	public SpringSessionController(SpringSessionRepository springSessionRepository) {
		this.springSessionRepository = springSessionRepository;
	}

	@GetMapping("/session")
	public String showSessionPage(Model model,
									Authentication authentication, 
									HttpSession session){
		

		Iterable<SpringSession> allSessions = springSessionRepository.findAll();
		List<SessionDisplay> sessionlist = new ArrayList<SessionDisplay>();
		
		Iterator<SpringSession> iter = allSessions.iterator();
		System.out.println("IN SESSION CONTROLLER");
		while(iter.hasNext()){
			SpringSession tmp = iter.next();
//			System.out.println("SESSION="+tmp.getPRIMARY_ID());
//			System.out.println("SESSION="+tmp.getPRINCIPAL_NAME());
			SessionDisplay sd = new SessionDisplay();
			sd.setCREATION_TIME(tmp.getCREATION_TIME());
			sd.setcreateDate(sd.getCREATION_TIME());
			sd.setEXPIRY_TIME(tmp.getEXPIRY_TIME());
			sd.setexpireDate(sd.getEXPIRY_TIME());
			sd.setPRINCIPAL_NAME(tmp.getPRINCIPAL_NAME());
			sd.setSESSION_ID(tmp.getSESSION_ID());
			//==================================
			//Date d2 = sd.getexpireDate();
			Date d2 = new Date();
			Date d1 = sd.getcreateDate();
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			
			String h=String.valueOf(diffHours);
			String m=String.valueOf(diffMinutes);
			String s=String.valueOf(diffSeconds);
			
			String connTime=h+" hours, "+m+" minutes, "+s+" seconds.";
			//System.out.println(connTime);
			sd.setConnectTime(connTime);
			sessionlist.add(sd);

		}
		
		
		if (!model.containsAttribute("")) {
			model.addAttribute("session", new SessionDisplay()); 
		}
		
		model.addAttribute("currentPrincipal", authentication.getName());			
		model.addAttribute("sessionlist", sessionlist);
		
		return "sessionlist";

	}

}