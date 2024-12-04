package spring_boot_board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_boot_board.mapper.LoginMapper;
import spring_boot_board.mapper.MemberMapper;

@Service
public class EmailCheckService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	MemberMapper memberMapper;
	public Integer execute(String userEmail) {
		return loginMapper.emailCheckSelectOne(userEmail);
	}
	public Integer update(String userEmail) {
		Integer i = loginMapper.emailCheckSelectOne(userEmail);
		// 1, null
		if(i != null) {
				i  = memberMapper.memberEmailCheckUpdate(userEmail);
				// 0, 1
		}
		return i;
	}
}
