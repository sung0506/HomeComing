package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import spring_boot_board.service.FileDelService;

@RestController
public class CheckRestController {
	@Autowired
	FileDelService fileDelService;
	@PostMapping("/file/fileDel")
	public int fileDel(String orgFile, String storeFile, HttpSession session) {
		 return  fileDelService.execute(orgFile, storeFile, session);
	}

}

