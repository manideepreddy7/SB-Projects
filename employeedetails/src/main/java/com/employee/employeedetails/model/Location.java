package com.employee.employeedetails.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
@Entity
@Table(name="Location")
public class Location {
	
	/* public Location(String city , int pcode , String stateName)
	{
		this.city=city;
		this.pcode=pcode;
		this.stateName=stateName;
	}
	*/
	
	@Id
	private String city;
	private int pcode;
	private String stateName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
      name = "OrgLocation", 
      joinColumns = @JoinColumn(name = "city"), 
      inverseJoinColumns = @JoinColumn(name = "cname"))
    private List<Organization> org_details;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Override
	public String toString() {
		return "Location [city=" + city + ", pcode=" + pcode + ", stateName=" + stateName + ", getCity()=" + getCity()
				+ ", getPcode()=" + getPcode() + ", getStateName()=" + getStateName() + "]";
	}
	
	

}
