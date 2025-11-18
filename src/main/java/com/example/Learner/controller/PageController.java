package com.example.Learner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/")
	public String homePage() {
		return "home";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}

	@GetMapping("/reset")
	public String resetPage() {
		return "reset";
	}

	@GetMapping("/ui/notes")
	public String notesPage() {
		return "notes";
	}
}
