package com.employee.common;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.employee.common.model.Employee;

@Consumes("application/xml")
@Produces("application/xml")
@Path("/employeeservice")
public interface EmployeeService {

	@Path("/employees")
	@GET
	List<Employee> getAllEmployeeDtls();

	@Path("/employees")
	@POST
	Response createEmployee(Employee employee);
	
	@Path("/employees/{id}")
	@PUT
	Response updateEmployee(Employee employee);

}
