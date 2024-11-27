package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import spring_boot_board.command.MemberCommand;
import spring_boot_board.service.AutoNumService;
import spring_boot_board.service.member.MemberDeleteService;
import spring_boot_board.service.member.MemberDetailService;
import spring_boot_board.service.member.MemberListService;
import spring_boot_board.service.member.MemberUpdateService;
import spring_boot_board.service.member.MemberWriteService;

@RequestMapping("member")
@Controller
public class MemberController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired	
	MemberWriteService memberWriteService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberUpdateService memberUpdateService;
	@Autowired
	MemberDeleteService memberDeleteService;
	@Autowired
	MemberListService memberListService;
	@GetMapping("memberList")
	public String list(
			 @RequestParam(value="page" , required = false , defaultValue = "1") Integer page
			,@RequestParam(value="searchWord", required = false ) String searchWord
			,Model model) {
		memberListService.execute(searchWord,page, model);
		return "thymeleaf/member/memberList";
	}
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
	/*
	@GetMapping("memberDetail")
	public String memberDetail(Model model, @RequestParam String memberNum) {
		memberDetailService.execute(model, memberNum);
		return "thymeleaf/member/memberDetail";
	}
	*/
	@GetMapping("memberDetail")
	public String memberDetail(Model model, HttpSession session) {
		memberDetailService.execute(model, session);
		return "thymeleaf/member/memberDetail";
	}
	
	@GetMapping("memberUpdate")
	public String memberUpdate(Model model, HttpSession session) {
		memberDetailService.execute(model, session);
		return "thymeleaf/member/memberModify";
	}
	@PostMapping("memberUpdate")
	public String memberUpdate(@Validated MemberCommand memberCommand,
			BindingResult result) {
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> {
	            System.out.println("Error: " + error.getDefaultMessage());
	        });
			return "thymeleaf/member/memberModify";
			
		}
		memberUpdateService.execute(memberCommand);
		return "redirect:memberDetail?memberNum=" + memberCommand.getMemberNum();
	}
	@GetMapping("memberDelete")
	public String memberDelete(@RequestParam String memberNum) {
		memberDeleteService.execute(memberNum);
		return "redirect:/";
	}
}


