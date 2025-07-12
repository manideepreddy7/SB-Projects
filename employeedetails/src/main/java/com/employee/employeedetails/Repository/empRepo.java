package com.employee.employeedetails.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.employeedetails.model.Employee;
import com.employee.employeedetails.model.Employeejoin;
import com.employee.employeedetails.model.Organization;

@Repository
public interface empRepo extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from employee  where exp>=:EMPexp", nativeQuery = true)
	public List<Employee> getByExperience(@Param("EMPexp") double EMPexp);
	
	@Query(value = "select o from organization o join o.employees e", nativeQuery = true)
	public List<Organization> joinEmpOrganization();
}
