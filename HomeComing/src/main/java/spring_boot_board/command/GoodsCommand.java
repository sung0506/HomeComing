package spring_boot_board.command;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data 
public class GoodsCommand {
	String goodsNum;
	@NotEmpty(message = "이름을 입력해주세요")
	String goodsName;
	@NotNull(message = "가격을 입력해주세요.")
	Integer goodsPrice;
	@NotEmpty(message = "설명을 입력해주세요")
	String goodsContents;
	@NotEmpty(message = "상품 종류를 입력해주세요")
	String goodsKind;
	String empNum;
	Date goodsRegist;
	String updateEmpNum;
    Date goodsUpdateDate;
	
    MultipartFile goodsMainImage;
	MultipartFile goodsDetailImage[];
}
