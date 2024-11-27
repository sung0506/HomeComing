package spring_boot_board.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring_boot_board.domain.EmployeeDTO;
import spring_boot_board.domain.StartEndPageDTO;
import spring_boot_board.mapper.EmployeeMapper;
import spring_boot_board.service.StartEndPageService;

@Service
public class EmployeeListService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	StartEndPageService startEndPageService;
	
	String searchWord;
	public void execute(String searchWord, int page, Model model) {
		int limit= 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit,  searchWord);
		List<EmployeeDTO> list = employeeMapper.employeeAllSelect(sepDTO);
		
		int count = employeeMapper.employeeCount(searchWord);
		startEndPageService.execute(page, limit, count, searchWord, list, model);
	}
}
