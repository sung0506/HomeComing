package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import spring_boot_board.command.CartCommand;
import spring_boot_board.service.item.CartInsertService;

@RestController  /// Rest API
@RequestMapping("item")
public class ItemRestController {
	@Autowired
	CartInsertService cartInsertService;
	@RequestMapping("cartAdd")
	public String cartAdd(@RequestBody CartCommand cartCommand
			, HttpSession session) {
		System.out.println(cartCommand.getGoodsNum());
		return cartInsertService.execute(cartCommand, session);
	}
}
