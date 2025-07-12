package com.employee.employeedetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeedetails.Repository.LocRepo;
import com.employee.employeedetails.Repository.empRepo;
import com.employee.employeedetails.Repository.orgRepo;
import com.employee.employeedetails.model.Employee;
import com.employee.employeedetails.model.Employeejoin;
import com.employee.employeedetails.model.Location;
import com.employee.employeedetails.model.Organization;

@Service
public class EmployeeService {

	@Autowired
	empRepo emprepo; 
	
	@Autowired
	orgRepo orgrepo;
	
	@Autowired
	LocRepo locrepo;
	
	@Autowired
	Organization org1;
	
	@Autowired
	Location loc1;
	
	public Employee getEmpById(int eid) {
		return emprepo.getById(eid);
	}
	
	public void updateEmployee(Employee emp) {
		emprepo.save(emp);
		System.out.println("Data Updated for "+emp.getEname());
	}
	
	public void addEmployee(Employee emp)
	{
		emprepo.save(emp);
		System.out.println("Data added for "+emp.getEname());
	}
	
	public List<Employee> getEmployee()
	{
		return emprepo.findAll();
	}
	
	public void deleteEmployee(int eid) {
		emprepo.deleteById(eid);
		System.out.println("Data deleted for "+eid);
	}
	
	public List<Employee> getByExp(double exp)
	{
		return emprepo.getByExperience(exp);
	}
	
	public List<Employeejoin> joinemporg()
	{
		return orgrepo.joinEmpsOrganization();
	}
	public List<Organization> joinlocOrganization()
	{
		
		org1.setCity("Pune");
		org1.setCname("Optum");
		org1.setEmpCount(217);
		orgrepo.save(org1);
		
		loc1.setCity("Pune");
		loc1.setStateName("Maharastra");
		locrepo.save(loc1);
		return locrepo.joinLocOrganization();
	}
	
}
