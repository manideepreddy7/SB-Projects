package com.employee.employeedetails.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
@Entity
@Table(name="Organization")
public class Organization {

 /*   public Organization(String cname , String city , int empCount)
    {
    	this.cname=cname;
    	this.city=city;
    	this.empCount=empCount;
    }
   */ 
	
	@Id
	private String cname;
	private String city;
	private int empCount;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cname",
    referencedColumnName = "cname")
	private List<Employee> employees;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "org_details")
	private List<Location> loc;
	
	public String getCname() {
		return cname;
		
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getEmpCount() {
		return empCount;
	}
	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}
	
}
