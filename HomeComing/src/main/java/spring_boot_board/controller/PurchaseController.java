package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import spring_boot_board.command.PurchaseCommand;
import spring_boot_board.service.purchase.GoodsBuyService;
import spring_boot_board.service.purchase.GoodsOrderService;
import spring_boot_board.service.purchase.IniPayReqService;
import spring_boot_board.service.purchase.OrderProcessListService;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	@Autowired
	OrderProcessListService orderProcessListService;
	@Autowired
	IniPayReqService iniPayReqService;
	@Autowired
	GoodsOrderService goodsOrderService;
	@Autowired
	GoodsBuyService goodsBuyService;
	@RequestMapping("goodsBuy")
	public String goodsBuy(String nums[] , HttpSession session,Model model) {
		goodsBuyService.execute(nums, session, model);
		return "thymeleaf/purchase/goodsOrder";
	}
	@PostMapping("goodsOrder")
	public String goodsOrder(PurchaseCommand purchaseCommand, HttpSession session,
			Model model) {
		String purchaseNum = goodsOrderService.execute(purchaseCommand, session, model);
		return "redirect:paymentOk?purchaseNum="+purchaseNum;
	}
	@GetMapping("paymentOk")
	public String paymentOk(String purchaseNum,Model model) {
		try {
			iniPayReqService.execute(purchaseNum, model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "thymeleaf/purchase/payment";
	}
	@GetMapping("orderList")
	public String orderList(HttpSession session, Model model) {
		orderProcessListService.execute(session, model, null);
		return "thymeleaf/purchase/orderList";
	}
}
