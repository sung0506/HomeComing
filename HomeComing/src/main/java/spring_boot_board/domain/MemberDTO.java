package spring_boot_board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
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
