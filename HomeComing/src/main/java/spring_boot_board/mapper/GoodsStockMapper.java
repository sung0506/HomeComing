package spring_boot_board.mapper;

import org.apache.ibatis.annotations.Mapper;

import spring_boot_board.domain.GoodsStockDTO;

@Mapper
public interface GoodsStockMapper {
	public GoodsStockDTO goodsStockSelectOne(String goodsNum);
	public int goodsVisitCountUpdate(String goodsNum);
}
