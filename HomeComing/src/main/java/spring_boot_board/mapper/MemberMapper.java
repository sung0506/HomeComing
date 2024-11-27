package spring_boot_board.mapper;

import org.apache.ibatis.annotations.Mapper;

import spring_boot_board.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public void memberInsert(MemberDTO dto);
	public MemberDTO memberSelectOne(String memberNum);
	public void memberUpdate(MemberDTO dto);
	public void memberDelete(String memberNum);
	public String memberNumById(String memberId);
}
