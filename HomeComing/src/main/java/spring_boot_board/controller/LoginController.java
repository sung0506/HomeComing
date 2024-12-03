package spring_boot_board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import spring_boot_board.command.LoginCommand;
import spring_boot_board.service.login.UserLoginService;

@RequestMapping("login")
@Controller
public class LoginController {
	@Autowired
	UserLoginService userLoginService;
	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("loginCommand", new LoginCommand());
		return "thymeleaf/login/login";
	}
	@PostMapping("signin")
	public String login(@Validated LoginCommand loginCommand
			,BindingResult result
			,HttpSession session
			,HttpServletResponse response) {
		userLoginService.execute(loginCommand, session, result, response);
		if(result.hasErrors()) {
			return "thymeleaf/login/login";
		}
		return "redirect:/";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("item.login")
	public String item() {
		return "thymeleaf/login/login1";
	}
	@PostMapping("item.login")
	public void item(LoginCommand loginCommand,BindingResult result
			,HttpSession session, HttpServletResponse response) {
		userLoginService.execute(loginCommand, session, result, response);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = "<script language='javascript'>";
			   str+= " opener.location.reload();";
			   str+= " window.self.close();";
		       str+= " </script>"; 
		out.print(str);
		out.close();
	}
}
