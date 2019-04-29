package br.edu.puc.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

	@GetMapping("/home")
	public String home() {
		return "<form action='/logout' method='post'><input type='submit' value='logout'/></form> ";
	}
}
