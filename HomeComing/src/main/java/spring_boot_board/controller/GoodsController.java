package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import spring_boot_board.command.GoodsCommand;
import spring_boot_board.service.AutoNumService;
import spring_boot_board.service.goods.GoodsDetailService;
import spring_boot_board.service.goods.GoodsListService;
import spring_boot_board.service.goods.GoodsRegistService;
import spring_boot_board.service.goods.KindGoodsListService;
import spring_boot_board.service.item.GoodsDetailViewService;

@RequestMapping("goods")
@Controller
public class GoodsController {
	@Autowired
	GoodsRegistService goodsRegistService;
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	KindGoodsListService kindGoodsListService;
	@Autowired
	GoodsDetailViewService goodsDetailViewService;
	@GetMapping("goodsList")
	@RequestMapping(value="goodsList" , method=RequestMethod.GET)
	public String  goodsList(
			@RequestParam(value="searchWord" , required = false) String searchWord,
			@RequestParam(value = "page" , required = false , defaultValue = "1") int page,
			Model model) {
		goodsListService.execute(searchWord, model, page);
		return "thymeleaf/goods/goodsList";
	}
	@GetMapping("goodsList/{goodsKind}")
	public String goodsListByCategory(
	        @PathVariable("goodsKind") String goodsKind,
	        @RequestParam(value = "searchWord", required = false) String searchWord,
	        @RequestParam(value = "page", required = false , defaultValue = "1") int page,
	        Model model) {
	    // 카테고리별 상품 리스트 처리
		System.out.println("goodsKind: " + goodsKind);
	    kindGoodsListService.execute(goodsKind, searchWord, model, page);
	    return "thymeleaf/goods/KindGoodsList";
	}
	@GetMapping("goodsInfo")
	public String goodsInfo() {
		return "thymeleaf/goods/goodsInfo";
	}
	@GetMapping("goodsRegist")
	public String goodsRegist(Model model) {
		String autoNum = autoNumService.execute("goods_", "goods_num", 7, "goods");
		GoodsCommand  goodsCommand = new GoodsCommand();
		goodsCommand.setGoodsNum(autoNum);
		model.addAttribute("goodsCommand", goodsCommand);
		return "thymeleaf/goods/goodsForm";
	}
	@PostMapping("goodsRegist")
	public String goodsRegist(@Validated GoodsCommand goodsCommand,BindingResult result
			,HttpSession session) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsForm";
		}
		goodsRegistService.execute(goodsCommand, session);
		return "redirect:goodsList";
	}
	@GetMapping("goodsDetail")
	public String goodsDetail(@RequestParam("goodsNum") String goodsNum
			,Model model,HttpSession session) {
		session.removeAttribute("fileList");
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsInfo";
	}
	/*
	@GetMapping("goodsDetail/{goodsNum}")
	public String goodsKindDetail(
			@PathVariable("goodsNum") String goodsNum,
			Model model, HttpServletResponse response, HttpSession session) {
		goodsDetailViewService.execute(goodsNum, model, response, session);
		return "thymeleaf/goods/goodsKindDetail";
		
	}
	*/
}
