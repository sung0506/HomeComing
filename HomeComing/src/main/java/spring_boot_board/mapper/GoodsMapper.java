package spring_boot_board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import spring_boot_board.domain.GoodsDTO;
import spring_boot_board.domain.StartEndPageDTO;

@Mapper
public interface GoodsMapper {
	public int goodsInsert(GoodsDTO dto);
	public List<GoodsDTO> allSelect(StartEndPageDTO sepDTO);
	public int goodsCount(String searchWord);
	public GoodsDTO selectOne(String goodsNum);
	public List<GoodsDTO> goodsListByKind(String goodsKind);
	public int goodsUpdate(GoodsDTO dto);
	public int goodsDelete(String goodsNum);
	public int productsDelete(@Param("products") String products[]);
}
