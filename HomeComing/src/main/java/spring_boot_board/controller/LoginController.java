package spring_boot_board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("login")
@Controller
public class LoginController {
	@GetMapping("/signup")
    public String showLoginPage() {
        return "thymeleaf/signup"; // 로그인 페이지 템플릿 반환
    }
}
