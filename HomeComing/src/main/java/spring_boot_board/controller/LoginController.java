package spring_boot_board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("login")
@Controller
public class LoginController {
	@GetMapping("login")
	public String login() {
		return "thymeleaf/login/login";
	}
	@PostMapping("signin")
	public String signin() {
		return "redirect:/";
	}
}
