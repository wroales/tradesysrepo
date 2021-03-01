package com.billr.tradesysv1.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.billr.tradesysv1.models.User;
import com.billr.tradesysv1.repository.UserRepository;

@Controller
public class UserController {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	private String theUser;
	
	public String getTheUser() {
		return theUser;
	}

	public void setTheUser(String theUser) {
		this.theUser = theUser;
	}

	
	@Autowired
	public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping("/")
	public String redirectPositionPage(HttpSession session,Authentication authentication) {
		System.out.println("SESSION ID="+session.getId());
		//System.out.println("SESSION last access="+session.getLastAccessedTime());
		System.out.println("USER ="+authentication.getName());
		
		User user = userRepository.findByUsername(authentication.getName());
		System.out.println("USER ROLE="+user.getUserRole());
		this.setTheUser(authentication.getName());
		if(user.getUserRole().equals("ROLE_ADMIN")) {
			return "redirect:/admin";
		}
		
		return "redirect:/position";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/about")
	public String showAboutPage() {
		return "about";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDeniedPage() {
		return "access_denied";
	}
	
	@GetMapping("/admin")
	public String showAdminPage(Model model) {
		
		if (!model.containsAttribute("users")) {
			model.addAttribute("users", new User());
		}
		Iterable<User> allUsers = userRepository.findAll();
			
		model.addAttribute("allUsers", allUsers);
		
		return "users";
	}
	
	@GetMapping("/editUser")
	public String editBookForm(@RequestParam("id") Integer id, Model model) {
		User user = userRepository.findById(id).get();
		model.addAttribute("user", user);
		return "edit_user";
	}
	
	@PostMapping("/editUser")
	public String editBook(@Valid @ModelAttribute("user") User us, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "edit_user";
		}
		User user = userRepository.findById(us.getUserId()).get();
		user.setUserRole(us.getUserRole());
		userRepository.save(user);
		return "redirect:/admin";
	}
	
	// Delete user by ID using a path variable
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
		return "redirect:/admin";
	}
	
	@GetMapping("/logoutSuccess")
	public String showLogoutPage(Model model) {
		model.addAttribute("uname", this.getTheUser());
		return "logout";
	}
	
	@GetMapping("/register")
	public String showRegistrationPage(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping("/register")
	public String registerNewUser(@Valid @ModelAttribute("user") User user, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "registration";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
		return "redirect:/login";
	}
}