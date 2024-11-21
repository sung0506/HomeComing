package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring_boot_board.command.MemberCommand;
import spring_boot_board.service.member.MemberWriteService;

@RequestMapping("member")
@Controller
public class MemberController {
	@Autowired
	MemberWriteService memberWriteService;
	@GetMapping("memberWrite")
    public String showLoginPage() {
        return "thymeleaf/member/memberForm"; // 로그인 페이지 템플릿 반환
    }
	@PostMapping("memberRegist")	
	public String signup(MemberCommand memberCommand) {
		memberWriteService.execute(memberCommand);
		return "redirect:/";
	}
}
