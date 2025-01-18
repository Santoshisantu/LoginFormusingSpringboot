package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.User;
import com.spring.repository.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}
	@PostMapping("/register")
public String regUser( @RequestParam("username") String username, 
        @RequestParam("userpwd") String userpwd,Model m) {
	if(repo.findById(username).isPresent()) {
		m.addAttribute("error","user already present");
		return "invalid";
	}
	User user=new User();
	user.setUsername(username);
	user.setUserpwd(userpwd);
	repo.save(user);
	m.addAttribute("success", "user registerd successfully...!");
	return "Regsucess";
	
}
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("username") String username, 
            @RequestParam("userpwd") String userpwd, 
            Model model) {
		
		User user=repo.findByNameAndPassword(username,userpwd);
		if(user!=null) {
			model.addAttribute("username", username);
			return "success";
			
			}
		else {
			model.addAttribute("error", "Invalid credentials");
			return "invalid";
		}
	}

}
