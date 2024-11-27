package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import spring_boot_board.command.EmployeeCommand;
import spring_boot_board.service.AutoNumService;
import spring_boot_board.service.employee.EmployeeDeleteService;
import spring_boot_board.service.employee.EmployeeDetailService;
import spring_boot_board.service.employee.EmployeeUpdateService;
import spring_boot_board.service.employee.EmployeeWriteService;

@RequestMapping("employee")
@Controller
public class EmployeeController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	EmployeeWriteService employeeWriteService;
	@Autowired
	EmployeeDetailService employeeDetailService;
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	@GetMapping("employeeWrite")
    public String showLoginPage(Model model) {
		String autoNum = autoNumService.execute("emp_", "emp_num", 5, "employees");
		EmployeeCommand  employeeCommand = new EmployeeCommand();
		employeeCommand.setEmpNum(autoNum);
		model.addAttribute("employeeCommand", employeeCommand);
        return "thymeleaf/employee/employeeForm"; // 로그인 페이지 템플릿 반환
    }
	@PostMapping("employeeRegist")	
	public String write(@Validated EmployeeCommand employeeCommand
			,BindingResult result
			/*, Model model*/) {
		if(result.hasErrors()) {
			return "thymeleaf/employee/employeeForm";
		}
		if(!employeeCommand.isEmployeePwEqualEmployeePwCon()) {
			//model.addAttribute("errPw","비밀번호가 일치하지 않아요. ");
			result.rejectValue("employeePwCon", "employeeCommand.empPwCon"
					, "비밀번호가 일치 하지 않습니다.");
			return "thymeleaf/employee/employeeForm";
		}
		employeeWriteService.execute(employeeCommand);
		return "redirect:/";
	}
	@GetMapping("employeeDetail")
	public String empDetail(Model model, HttpSession session) {
		employeeDetailService.execute(model, session);
		return "thymeleaf/employee/employeeDetail";
	}
	@GetMapping("employeeUpdate")
	public String empUpdate(Model model, HttpSession session) {
		employeeDetailService.execute(model, session);
		return "thymeleaf/employee/employeeModify";
	}
	@PostMapping("employeeUpdate")
	public String empUpdate(@Validated EmployeeCommand employeeCommand,
			BindingResult result) {
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> {
	            System.out.println("Error: " + error.getDefaultMessage());
	        });
			return "thymeleaf/employee/employeeModify";
			
		}
		employeeUpdateService.execute(employeeCommand);
		return "redirect:employeeDetail?empNum=" + employeeCommand.getEmpNum();
	}
	@GetMapping("employeeDelete")
	public String empDelete(@RequestParam String empNum) {
		employeeDeleteService.execute(empNum);
		return "redirect:/";
	}
}
