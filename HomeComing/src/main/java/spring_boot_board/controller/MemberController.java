package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring_boot_board.command.MemberCommand;
import spring_boot_board.service.AutoNumService;
import spring_boot_board.service.member.MemberWriteService;

@RequestMapping("member")
@Controller
public class MemberController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired	
	MemberWriteService memberWriteService;
	@GetMapping("memberWrite")
    public String showLoginPage(Model model) {
		String autoNum = autoNumService.execute("mem_", "member_num", 5, "members");
		MemberCommand  memberCommand = new MemberCommand();
		memberCommand.setMemberNum(autoNum);
		model.addAttribute("memberCommand", memberCommand);
        return "thymeleaf/member/memberForm"; // 로그인 페이지 템플릿 반환
    }
	@PostMapping("memberRegist")
	public String write(@Validated MemberCommand memberCommand
			,BindingResult result
			/*, Model model*/) {
		if(result.hasErrors()) {
			System.out.println("Validation errors detected.");
			return "thymeleaf/member/memberForm";
		}
		if(!memberCommand.isMemberPwEqualMemberPwCon()) {
			//model.addAttribute("errPw","비밀번호가 일치하지 않아요. ");
			result.rejectValue("memberPwCon", "memberCommand.memberPwCon"
					, "비밀번호가 일치 하지 않습니다.");
			return "thymeleaf/member/memberForm";
		}
		memberWriteService.execute(memberCommand);
		return "redirect:/";
	}
}


