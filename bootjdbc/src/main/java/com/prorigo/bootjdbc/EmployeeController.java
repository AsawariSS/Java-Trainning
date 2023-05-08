package com.prorigo.bootjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@PostMapping("addEmployee")
	public String addEmployee(Employee employee) {

		String insertQuery = "insert into employee" + "(firstname,lastname,address,qualifications,dept,desi)" + "values"
				+ "(?,?,?,?,?,?)";
		int rows = jdbcTemplate.update(insertQuery, employee.getFirstname(), employee.getLastname(),
				employee.getAddress(), employee.getQualifications(), employee.getDept(), employee.getDesi());
		if (rows == 1) {
			return "success";
		} else {
			return "error";
		}
	}

}
