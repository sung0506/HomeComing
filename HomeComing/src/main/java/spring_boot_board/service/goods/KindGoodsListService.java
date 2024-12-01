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
	public class KindGoodsListService {
	    @Autowired
	    GoodsMapper goodsMapper;
	    @Autowired
	    StartEndPageService startEndPageService;
	
	    public void execute(String goodsKind, String searchWord, Model model, int page) {
	    	System.out.println("goodsKind : " + goodsKind );
	        // 한 페이지에 보일 리스트 수
	        int limit = 3;
	
	        // StartEndPageDTO 생성 (페이징 처리)
	        StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord);
	
	        
	        // 상품 리스트 조회
	        
	        List<GoodsDTO> list = goodsMapper.goodsListByKind(goodsKind);
	        int count = goodsMapper.goodsCount(searchWord);
	
	        // 페이징 처리
	        startEndPageService.execute(page, limit, count, searchWord, list, model);
	        
	        
	        model.addAttribute("goodsList", list);
	    }
	}
