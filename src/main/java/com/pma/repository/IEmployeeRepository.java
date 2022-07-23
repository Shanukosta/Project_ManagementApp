package com.pma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pma.dto.EmployeeProject;
import com.pma.entity.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Override
	List<Employee> findAll();
	
	@Query(nativeQuery = true, value="Select e.first_name as firstName, e.last_name as lastName, count(pe.employee_id) as projectCount "+
			"FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id " +
			"GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
	List<EmployeeProject> employeeProjects();
}
