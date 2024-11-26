package spring_boot_board.command;

import org.apache.ibatis.type.Alias;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Alias("memberDTO")
public class MemberCommand {
	String memberNum;
	@NotEmpty(message = "이름을 입력해주세요")
	String memberName;
	@NotEmpty(message = "아이디를 입력해주세요")
	String memberId;
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
			message = "영문자와 숫자 그리고 특수문자가 포함된 8글자 이상")
	String memberPw;
	@NotBlank(message = "비밀번호 확인을 입력해주세요.")		
	String memberPwCon;
	@NotBlank(message = "이메일을 입력하여 주세요.")
	String memberEmail;
	String memberPost;
	@NotBlank(message = "연락처을 입력하여 주세요.")
	@Size(min = 11, max = 23)
	String memberPhone;
	String gender;
	@NotBlank(message = "주소를 입력하여 주세요.")
	String memberAddr;
	String memberAddrDetail;
	
	public boolean isMemberPwEqualMemberPwCon() {
		System.out.println("memberPw: " + memberPw);
	    System.out.println("memberPwCon: " + memberPwCon);
		return memberPw.equals(memberPwCon);
	}
}
