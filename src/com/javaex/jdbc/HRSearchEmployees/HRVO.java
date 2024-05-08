package com.javaex.jdbc.HRSearchEmployees;

import java.sql.Date;

public class HRVO {

	private String name;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	
	public HRVO(String name, String email, String phoneNumber, Date hireDate) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
	}

	public HRVO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "HRVO [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate
				+ "]";
	}
	
	
	
}
