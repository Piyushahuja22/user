package com.instainsurance.insuranceappl.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {
	@Id
	@Column(name = "vehicle_registration_number")
	private String vehicleRegNo;
	
	@Column(name = "vehicle_value")
	private Integer VehicleValue;
	
	@Column(name = "vehicle_type")
	private String vehicleType;
	
	@Column(name = "vehicle_number_of_seat")
	private Integer vehicleNoOfSeat;
	
	@Column(name = "vehicle_manufacturer")
	private String vehicleManufacturer;
	
	@Column(name = "vehicle_engine_number")
	private Integer vehicleEngineNo;
	
	@Column(name = "vehicle_chasis_number")
	private Integer vehicleChasisNo;
	
	@Column(name = "vehicle_number")
	private String vehicleNumber;
	
	@Column(name = "vehicle_model")
	private String vehicleModel;
	
	@Column(name = "vehicle_model_number")
	private String vehicleModelNumber;
	
	@Column(name = "vehicle_old_or_new")
	private String vehicleOldOrNew;
	
	@Column(name = "vehicle_fuel")
	private String vehicleFuel;
	
	@Column(name = "vehicle_registration_place")
	private String vehicleRegistrationPlace;	
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	
	
	
	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleOldOrNew() {
		return vehicleOldOrNew;
	}

	public void setVehicleOldOrNew(String vehicleOldOrNew) {
		this.vehicleOldOrNew = vehicleOldOrNew;
	}

	public String getVehicleFuel() {
		return vehicleFuel;
	}

	public void setVehicleFuel(String vehicleFuel) {
		this.vehicleFuel = vehicleFuel;
	}

	public String getVehicleRegistrationPlace() {
		return vehicleRegistrationPlace;
	}

	public void setVehicleRegistrationPlace(String vehicleRegistrationPlace) {
		this.vehicleRegistrationPlace = vehicleRegistrationPlace;
	}

	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

	public Integer getVehicleValue() {
		return VehicleValue;
	}

	public void setVehicleValue(Integer vehicleValue) {
		VehicleValue = vehicleValue;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Integer getVehicleNoOfSeat() {
		return vehicleNoOfSeat;
	}

	public void setVehicleNoOfSeat(Integer vehicleNoOfSeat) {
		this.vehicleNoOfSeat = vehicleNoOfSeat;
	}

	public String getVehicleManufacturer() {
		return vehicleManufacturer;
	}

	public void setVehicleManufacturer(String vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}

	public Integer getVehicleEngineNo() {
		return vehicleEngineNo;
	}

	public void setVehicleEngineNo(Integer vehicleEngineNo) {
		this.vehicleEngineNo = vehicleEngineNo;
	}

	public Integer getVehicleChasisNo() {
		return vehicleChasisNo;
	}

	public void setVehicleChasisNo(Integer vehicleChasisNo) {
		this.vehicleChasisNo = vehicleChasisNo;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleModelNumber() {
		return vehicleModelNumber;
	}

	public void setVehicleModelNumber(String vehicleModelNumber) {
		this.vehicleModelNumber = vehicleModelNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleRegNo=" + vehicleRegNo + ", VehicleValue=" + VehicleValue + ", vehicleType="
				+ vehicleType + ", vehicleNoOfSeat=" + vehicleNoOfSeat + ", vehicleManufacturer=" + vehicleManufacturer
				+ ", vehicleEngineNo=" + vehicleEngineNo + ", vehicleChasisNo=" + vehicleChasisNo + ", vehicleNumber="
				+ vehicleNumber + ", vehicleModel=" + vehicleModel + ", vehicleModelNumber=" + vehicleModelNumber
				+ ", vehicleOldOrNew=" + vehicleOldOrNew + ", vehicleFuel=" + vehicleFuel
				+ ", vehicleRegistrationPlace=" + vehicleRegistrationPlace + ", customer=" + customer + "]";
	}
}
