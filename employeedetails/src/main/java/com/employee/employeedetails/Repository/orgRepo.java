package com.employee.employeedetails.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.employeedetails.model.Employeejoin;
import com.employee.employeedetails.model.Organization;

@Repository
public interface orgRepo extends JpaRepository<Organization, String>{

	@Query("select new com.employee.employeedetails.model.Employeejoin(o.cname,e.ename) from Organization o join o.employees e")
	public List<Employeejoin> joinEmpsOrganization();
}
