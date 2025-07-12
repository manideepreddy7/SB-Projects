package com.employee.employeedetails.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.employeedetails.model.Location;
import com.employee.employeedetails.model.Organization;

public interface LocRepo extends JpaRepository<Location, String>{

	@Query("select o from Organization o join Location l on o.city=l.city")
	public List<Organization> joinLocOrganization();
}
