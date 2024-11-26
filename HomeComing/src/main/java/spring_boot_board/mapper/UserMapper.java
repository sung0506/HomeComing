package spring_boot_board.mapper;

import org.apache.ibatis.annotations.Mapper;

import spring_boot_board.domain.MemberDTO;

@Mapper
public interface UserMapper {
	public Integer userInsert(MemberDTO dto);
}
