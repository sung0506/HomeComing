package spring_boot_board.command;

import lombok.Data;

@Data
public class CartCommand {
	String goodsNum;
	Integer qty;
}
