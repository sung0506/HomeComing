package spring_boot_board.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import spring_boot_board.domain.AuthInfoDTO;
import spring_boot_board.domain.EmployeeDTO;
import spring_boot_board.mapper.EmployeeMapper;

@Service
public class EmployeeDetailService {
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String empNum = employeeMapper.employeeNumById(auth.getUserId());
		EmployeeDTO dto = employeeMapper.employeeSelectOne(empNum);
		model.addAttribute("employeeCommand", dto);
	}
}
