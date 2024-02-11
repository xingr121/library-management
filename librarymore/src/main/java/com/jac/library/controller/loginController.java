package com.jac.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {


	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "login";
	}
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
