package com.employee.employeedetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.employee.employeedetails.model.Employee;
import com.employee.employeedetails.model.Employeejoin;
import com.employee.employeedetails.model.Organization;
import com.employee.employeedetails.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService es;
	
	@GetMapping("/details")
	public List<Employee> EmployeeDetails() {
		return es.getEmployee();
	}
	
	@GetMapping("/detailsById")
	public Employee empDetailsById(@RequestParam int eid ){
		return es.getEmpById(eid);
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody Employee emp) {
		es.updateEmployee(emp);
		return ResponseEntity.ok("Employee " +emp + " Updated successfully!");
	}
	
	
	
	@PostMapping("/save")
    public ResponseEntity<String> createUser(@RequestBody Employee emp) {
		es.addEmployee(emp);
        return ResponseEntity.ok("Employee " +emp + " created successfully!");
	}  
        
   @GetMapping("/delete") 
    public ResponseEntity<String> deleteUser(@RequestParam int eid){
    	es.deleteEmployee(eid);
    	return ResponseEntity.ok("Employee " +eid + " Deleted successfully!");
    }
	
   @GetMapping("/getbyexp/{exp}")
   public List<Employee> getbyexp(@PathVariable("exp") double exp)
   {
	   return es.getByExp(exp);
	   //return ResponseEntity.ok("Employee details Fetched based on experience successfully!");
   }
   
   @GetMapping("/getJoinData")
	   public List<Employeejoin> getjoindata()
	   {
		   return es.joinemporg();
		   //return ResponseEntity.ok("Employee details Fetched based on experience successfully!");
	   }
   @GetMapping("/getOrgJoinLoc")
   public List<Organization> joinlocOrg()
   {
	   return es.joinlocOrganization();
   }
   
   }
   
	
