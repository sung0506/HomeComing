package spring_boot_board.mapper;

import org.apache.ibatis.annotations.Mapper;

import spring_boot_board.domain.EmployeeDTO;
import spring_boot_board.domain.MemberDTO;

@Mapper
public interface EmployeeMapper {
	public void employeeInsert(EmployeeDTO dto);
	public EmployeeDTO employeeSelectOne(String empNum);
	public void employeeUpdate(EmployeeDTO dto);
	public void employeeDelete(String empNum);
}
