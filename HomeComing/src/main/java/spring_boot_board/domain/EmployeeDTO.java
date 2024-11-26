package spring_boot_board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	String empNum;
	String empName;
	String empId;
	String empPw;
	String empEmail;
	String empAddr;
	String empAddrDetail;
	String empPost;
	String empPhone;
	String empJumin;
}
