package spring_boot_board.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import spring_boot_board.command.MemberCommand;
import spring_boot_board.domain.MemberDTO;
import spring_boot_board.mapper.MemberMapper;

@Service
public class MemberWriteService {
	@Autowired
	MemberMapper memberMapper;	
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setGender(memberCommand.getGender());
		dto.setMemberAddr(memberCommand.getMemberAddr());
		dto.setMemberAddrDetail(memberCommand.getMemberAddrDetail());
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberId(memberCommand.getMemberId());
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberNum(memberCommand.getMemberNum());
		dto.setMemberPhone(memberCommand.getMemberPhone());
		dto.setMemberPost(memberCommand.getMemberPost());
		
		String encodePw = passwordEncoder.encode(memberCommand.getMemberPw());
		dto.setMemberPw(encodePw);
		
		memberMapper.memberInsert(dto);
	}
}
