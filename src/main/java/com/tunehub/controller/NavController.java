package com.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavController {

	@GetMapping("/map-register")
	public String registerMapping() {
		return "register";
	}
	@GetMapping("/map-login")
	public String loginMapping() {
		return "login";
	}
	@GetMapping("/map-addsong")
	public String mapSongs() {
		return "addsongs";
	}
	@GetMapping("/payment")
	public String makePayment() {
		return "samplePayment";
	}
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
}
