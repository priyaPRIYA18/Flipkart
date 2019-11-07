package com.example.employee.EmployeeData.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="EMP")
@Data
public class User
{
	@Column(name="employeeName")
	private String employeeName;
	
	@Column(name="emailid")
	private String emailid;
	
	@Column(name="location")
	private String location;

	public User(String employeeName, String emailid, String location, int employeeId) {
		super();
		this.employeeName = employeeName;
		this.emailid = emailid;
		this.location = location;
		this.employeeId = employeeId;
}
	
	public User()
	{
		
	}
	
	@Id
	
	@Column(name="employeeId")
	private int employeeId;

	
}
