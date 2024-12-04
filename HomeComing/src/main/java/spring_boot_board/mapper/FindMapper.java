package spring_boot_board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import spring_boot_board.domain.UserChangePasswordDTO;

@Mapper
public interface FindMapper {
	public String findId(@Param("_userPhone")String userPhone
					   , @Param("_userEmail")String userEmail);
	public int pwUpdate(UserChangePasswordDTO dto);
}
