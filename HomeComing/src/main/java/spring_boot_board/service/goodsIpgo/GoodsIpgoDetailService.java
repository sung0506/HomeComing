package spring_boot_board.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring_boot_board.domain.GoodsIpgoGoodsNameDTO;
import spring_boot_board.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoDetailService {
   @Autowired
   GoodsIpgoMapper goodsIpgoMapper;
   public GoodsIpgoGoodsNameDTO execute(String ipgoNum,String goodsNum,Model model) {
      GoodsIpgoGoodsNameDTO dto = goodsIpgoMapper.ipgoGoodsSelectOne(ipgoNum, goodsNum) ;
      model.addAttribute("dto", dto);
      return dto;
   }
}

