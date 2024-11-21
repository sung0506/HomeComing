package spring_boot_board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("employee")
@Controller
public class EmployeeController {
	@GetMapping("employeeWrite")
    public String showLoginPage() {
        return "thymeleaf/employee/employeeForm"; // 로그인 페이지 템플릿 반환
    }
	@PostMapping("employeeRegist")	
	public String signup() {
		
		return "redirect:/";
	}
}
