package spring_boot_board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import spring_boot_board.domain.EmployeeDTO;
import spring_boot_board.domain.StartEndPageDTO;

@Mapper
public interface EmployeeMapper {
	public void employeeInsert(EmployeeDTO dto);
	public EmployeeDTO employeeSelectOne(String empNum);
	public void employeeUpdate(EmployeeDTO dto);
	public void employeeDelete(String empNum);
	public String employeeNumById(String empId);
	public String getEmpNum(String empId);
	public List<EmployeeDTO> employeeAllSelect(StartEndPageDTO sepDTO);
	public int employeeCount(String searchWord);
	
}
