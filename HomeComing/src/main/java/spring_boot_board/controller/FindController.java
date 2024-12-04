package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring_boot_board.service.find.FindIdService;
import spring_boot_board.service.find.FindPwService;

@Controller
@RequestMapping("find")
public class FindController {
	@Autowired
	FindPwService findPwService;
	@Autowired
	FindIdService findIdService;
	@RequestMapping(value="findId", method = RequestMethod.GET)
	public String findId() {
		return "thymeleaf/find/findId";
	}
	@RequestMapping(value="findId", method = RequestMethod.POST)
	public String findId(
			@RequestParam("userPhone")String userPhone,
			@RequestParam("userEmail")String userEmail,
			Model model) {
		findIdService.execute(userPhone, userEmail, model);
		return "thymeleaf/find/findIdOk";
	}
	@GetMapping("findPassword")
	public String findPassword() {
		return "thymeleaf/find/findPw";
	}
	@PostMapping("findPassword")
	public String findPassword(String userId,String userPhone,Model model) {
		findPwService.execute(userId, userPhone,model);
		return "thymeleaf/find/findPwOk";
	}
}
