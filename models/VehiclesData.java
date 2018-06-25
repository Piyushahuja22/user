/**
 * 
 */
package com.instainsurance.insuranceappl.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LTI
 *
 */

@Entity
@Table(name = "vehicles_data")
public class VehiclesData {

	@Id
	@Column(name = "vehicles_maker_name")
	private String vehiclesMakerName;
	
	@Column(name = "vehicles_price")
	private Double vehiclesValue;

	public String getVehiclesMakerName() {
		return vehiclesMakerName;
	}

	public void setVehiclesMakerName(String vehiclesMakerName) {
		this.vehiclesMakerName = vehiclesMakerName;
	}

	public Double getVehiclesValue() {
		return vehiclesValue;
	}

	public void setVehiclesValue(Double vehiclesValue) {
		this.vehiclesValue = vehiclesValue;
	}

	@Override
	public String toString() {
		return "VehicleData [vehiclesMakerName=" + vehiclesMakerName + ", vehiclesValue=" + vehiclesValue + "]";
	}
	
}
