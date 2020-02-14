package com.employee.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.employee.common.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	Map<Integer, Employee> employees = new HashMap<>();
	int currentId = 1;

	public EmployeeServiceImpl() {
		init();
	}

	public void init() {
		Employee employee = new Employee();
		employee.setId(currentId);
		employee.setFirstName("Desuza");
		employee.setLastName("Lobo");
		employee.setDept("Eng");
		employee.setHomeAddress("kr puram");
		employee.setOfficeAddress("Whitefield");
		employee.setIdCardNo("ALS451W");
		employee.setPhoneNumer("9836378827");

		employees.put(employee.getId(), employee);
	}

	@Override
	public List<Employee> getAllEmployeeDtls() {
		Collection<Employee> result = employees.values();
		ArrayList<Employee> response = new ArrayList<>(result);
		return response;
	}

	@Override
	public Response createEmployee(Employee employee) {
		// Employee createEmployee = new Employee();
		employee.setId(currentId++);
		employees.put(employee.getId(), employee);
		return Response.ok(employee).build();
	}

	@Override
	public Response updateEmployee(Employee employee) {
		Employee updateEmployee = employees.get(employee.getId());
		Response response;

		if (updateEmployee != null) {
			employees.put(employee.getId(), employee);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}

		return response;
	}

}
