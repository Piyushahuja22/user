package com.instainsurance.insuranceappl.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "temp_quote")
public class TempQuote {

	public TempQuote() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name = "Vehicle_Registration_Number")
	private String vehicleRegNo;

	@Column(name = "Vehicle_Type")
	private String vehicleType;

	@Column(name = "Vehicle_Old_Or_New")
	private String vehicleOldOrNew;

	@Column(name = "Vehicle_Model")
	private String model;

	@Column(name = "Vehicle_Model_Number")
	private String vehicleModelNo;

	@Column(name = "Vehicle_Fuel")
	private String vehicleFuel;

	@Column(name = "Vehicle_Registration_Place")
	private String vehicleRegPlace;
	
	@Column(name = "Customer_First_Name")
	private String customerFirstName;
	
	@Column(name = "Customer_Last_Name")
	private String customerLastName;

	@Column(name = "Customer_Mobile_Number")
	private String customerMobNo;

	@Column(name = "Customer_Email")
	private String customerEmail;

	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleOldOrNew() {
		return vehicleOldOrNew;
	}

	public void setVehicleOldOrNew(String vehicleOldOrNew) {
		this.vehicleOldOrNew = vehicleOldOrNew;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVehicleModelNo() {
		return vehicleModelNo;
	}

	public void setVehicleModelNo(String vehicleModelNo) {
		this.vehicleModelNo = vehicleModelNo;
	}

	public String getVehicleFuel() {
		return vehicleFuel;
	}

	public void setVehicleFuel(String vehicleFuel) {
		this.vehicleFuel = vehicleFuel;
	}

	public String getVehicleRegPlace() {
		return vehicleRegPlace;
	}

	public void setVehicleRegPlace(String vehicleRegPlace) {
		this.vehicleRegPlace = vehicleRegPlace;
	}

	public String getCustomerMobNo() {
		return customerMobNo;
	}

	public void setCustomerMobNo(String customerMobNo) {
		this.customerMobNo = customerMobNo;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	

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

	@Override
	public String toString() {
		return "TempQuote [vehicleRegNo=" + vehicleRegNo + ", vehicleType=" + vehicleType + ", vehicleOldOrNew="
				+ vehicleOldOrNew + ", Model=" + model + ", vehicleModelNo=" + vehicleModelNo + ", vehicleFuel="
				+ vehicleFuel + ", vehicleRegPlace=" + vehicleRegPlace + ", customerMobNo=" + customerMobNo
				+ ", customerEmail=" + customerEmail + "]";
	}
	
	
	

}
