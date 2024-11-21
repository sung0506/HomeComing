package spring_boot_board.command;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("memberDTO")
public class MemberCommand {
	String memberNum;
	String memberName;
	String memberId;
	String memberPw;
	String memberEmail;
	String memberPost;
	String memberPhone;
	String gender;
	String memberAddr;
	String memberAddrDetail;
}
