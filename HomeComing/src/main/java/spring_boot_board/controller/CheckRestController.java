package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import spring_boot_board.service.EmailCheckService;
import spring_boot_board.service.FileDelService;

@RestController
public class CheckRestController {
	@Autowired
	FileDelService fileDelService;
	@Autowired
	EmailCheckService emailCheckService;
	@PostMapping("/file/fileDel")
	public int fileDel(String orgFile, String storeFile, HttpSession session) {
		 return  fileDelService.execute(orgFile, storeFile, session);
	}
	@PostMapping("/checkRest/userEmailCheck")
	public Integer emailCheck(String userEmail) {
		return emailCheckService.execute(userEmail);
	}
}

