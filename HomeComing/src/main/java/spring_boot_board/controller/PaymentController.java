package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import spring_boot_board.service.purchase.INIstdpayPcReturn;

@Controller
@RequestMapping("payment")
public class PaymentController {
	@Autowired
	INIstdpayPcReturn iniPayReturnService;
	@RequestMapping("INIstdpay_pc_return")
	public String payReturn(HttpServletRequest request) {
		iniPayReturnService.execute(request);
		return "thymeleaf/purchase/buyfinished";
	}
}
