package org.saurabh.billing;

import java.util.Date;

public class Customer {
	
	private String mobileNumber;
	
	private String name;
	
	private Date dateOfEnrollment;
	
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfEnrollment() {
		return dateOfEnrollment;
	}
	public void setDateOfEnrollment(Date dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}
	
	
	

}
