package spring_boot_board.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring_boot_board.domain.EmployeeDTO;
import spring_boot_board.mapper.EmployeeMapper;

@Service
public class EmployeeDetailService {
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(Model model, String empNum) {
		EmployeeDTO dto = employeeMapper.employeeSelectOne(empNum);
		model.addAttribute("employeeCommand", dto);
	}
}
