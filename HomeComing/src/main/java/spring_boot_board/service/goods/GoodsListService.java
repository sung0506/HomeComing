package spring_boot_board.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring_boot_board.domain.GoodsDTO;
import spring_boot_board.domain.StartEndPageDTO;
import spring_boot_board.mapper.GoodsMapper;
import spring_boot_board.service.StartEndPageService;

@Service
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(String searchWord , Model model, int page) {
		// 한페이지에 보일 list
		int limit = 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(page,limit, searchWord);
				
		List<GoodsDTO> list = goodsMapper.allSelect(sepDTO);
		int count = goodsMapper.goodsCount(searchWord);
		// 페이징
		startEndPageService.execute(page,limit, count, searchWord,list, model);
	}
}
