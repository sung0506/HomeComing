package spring_boot_board.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_boot_board.mapper.EmployeeMapper;

@Service
public class EmployeeDeleteService {
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(String empNum) {
		employeeMapper.employeeDelete(empNum);
	}
}
