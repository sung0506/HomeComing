package spring_boot_board.service.goodsIpgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring_boot_board.domain.GoodsIpgoDTO;
import spring_boot_board.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoListService {
   @Autowired
   GoodsIpgoMapper goodsIpgoMapper;
   public void execute(Model model) {
      List<GoodsIpgoDTO> list = goodsIpgoMapper.goodsIpgoSelectList();
      model.addAttribute("list", list);
   }
}

