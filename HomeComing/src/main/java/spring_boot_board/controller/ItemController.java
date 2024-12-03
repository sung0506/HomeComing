package spring_boot_board.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import spring_boot_board.command.CartCommand;
import spring_boot_board.service.item.CartInsertService;
import spring_boot_board.service.item.CartListService;

@Controller
@RequestMapping("item")
public class ItemController {
	@Autowired
	CartInsertService cartInsertService;
	@Autowired
	CartListService cartListService;
	@RequestMapping("cartList")
	public String cartList(Model model, HttpSession session) {
		cartListService.execute(model, session);
		return "thymeleaf/item/cartList";
	}
	@GetMapping("buyItem")
	public String buyItem(CartCommand cartCommand, HttpSession session
			, HttpServletResponse response) {
		String result = cartInsertService.execute(cartCommand, session);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out;
		if(result == "000") {
			return "redirect:/";
		}else if(result == "900") {
			String str = "<script>"
					   + "alert('관리자는 구매할 수 없습니다.');"
					   + "location.href='/corner/detailView/"+cartCommand.getGoodsNum()+"';"
					   +"</script>";
			try {
			out = response.getWriter();
			out.print(str);
			out.close();
			}catch(Exception e) {}
		}
		return "redirect:/purchase/goodsBuy?nums="+cartCommand.getGoodsNum();
		/*
		if(result == "200")
			return "redirect:/purchase/goodsBuy?nums="+cartCommand.getGoodsNum();
		else if(result == "000")
			return "redirect:/";
		else if(result == "900")	
			return "redirect:/corner/detailView/"+cartCommand.getGoodsNum();
		*/
	}
}
