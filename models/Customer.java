package com.instainsurance.insuranceappl.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "customer_dob")
	private Date customerDob;
	
	@Column(name = "customer_first_name")
	private String customerFirstName;
	
	@Column(name = "customer_last_name")
	private String customerLastName;
	
	@Column(name = "customer_gender")
	private String customerGender;
	
	@Column(name = "customer_address")
	private String customerAddress;
	
	@Column(name = "customer_mob_number")
	private Integer customerMobNo;
	
	@Column(name = "customer_email")
	private String customerEmail;
	
	@Column(name = "customer_password")
	private String customerPassword;
	
	@Column(name = "customer_passport_number")
	private String customerPassport;

	@Column(name = "customer_marital_status")
	private String customerMaritalStatus;
	
	@Column(name = "customer_aadhar_no")
	private Integer customerAadharNo;
	
	@OneToMany(mappedBy="customer")
	private List<Quote> quotes;
	
	@OneToMany(mappedBy="customer")
	private List<Vehicle> vehicles;	
	
/*	@OneToOne
	private User user;*/
	
	public String getCustomerId() {
		return customerId;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Integer getCustomerMobNo() {
		return customerMobNo;
	}

	public void setCustomerMobNo(Integer customerMobNo) {
		this.customerMobNo = customerMobNo;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassport() {
		return customerPassport;
	}

	public void setCustomerPassport(String customerPassport) {
		this.customerPassport = customerPassport;
	}

	public String getCustomerMaritalStatus() {
		return customerMaritalStatus;
	}

	public void setCustomerMaritalStatus(String customerMaritalStatus) {
		this.customerMaritalStatus = customerMaritalStatus;
	}

	public Integer getCustomerAadhaarNo() {
		return customerAadharNo;
	}

	public void setCustomerAadhaarNo(Integer customerAadharNo) {
		this.customerAadharNo = customerAadharNo;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	
	
	
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}



}
