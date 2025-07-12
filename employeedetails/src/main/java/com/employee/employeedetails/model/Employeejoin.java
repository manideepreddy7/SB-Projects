package com.employee.employeedetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Employeejoin {
	
	public Employeejoin(String cname , String ename)
	{
		this.cname=cname;
		this.ename=ename;
	}
	
	String cname;
	String ename;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Override
	public String toString() {
		return "Employeejoin [cname=" + cname + ", ename=" + ename + ", getCname()=" + getCname() + ", getEname()="
				+ getEname() + "]";
	}
}
