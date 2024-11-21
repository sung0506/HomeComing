package spring_boot_board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("goods")
@Controller
public class GoodsController {
	@GetMapping("goodsList")
	public String goods() {
		return "thymeleaf/goods/goodsList";
	}
	@GetMapping("goodsInfo")
	public String goodsInfo() {
		return "thymeleaf/goods/goodsInfo";
	}
}
