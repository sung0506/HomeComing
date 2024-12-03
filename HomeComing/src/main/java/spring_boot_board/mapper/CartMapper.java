package spring_boot_board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import spring_boot_board.domain.CartDTO;
import spring_boot_board.domain.GoodsCartDTO;

@Mapper
public interface CartMapper {
	public void cartMerge(CartDTO dto);
	public CartDTO cartSelect(Integer cartNum);
	public List<GoodsCartDTO> cartSelectList(
			@Param("memberNum") String memberNum, 
			@Param("nums") String [] nums);
	public int goodsNumsDelete(Map<String, Object> condition);
}
