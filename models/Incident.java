package com.instainsurance.insuranceappl.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "incident")
public class Incident {

	@Id
	@Column(name = "incident_id")
	private String incidentId;
	
	@Column(name = "incident_type")
	private String incidentType;
	

	@Column(name = "incident_date")
	@Temporal(TemporalType.DATE)
	private Date incidentDate;
	
	@Column(name = "description")
	private String desc;
	
	@Column(name = "incident_status")
	private String incidentStatus;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "incident_image")
	private String image;
	
	public String getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}
	
	public String getIncidentStatus() {
		return incidentStatus;
	}

	public void setIncidentStatus(String incidentStatus) {
		this.incidentStatus = incidentStatus;
	}

	public String getIncidentType() {
		return incidentType;
	}

	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}

	public Date getIncidentDate() {
		return incidentDate;
	}
	
	public void setIncidentDate(Date incidentDate) {
		this.incidentDate = incidentDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Incident [incidentId=" + incidentId + ", incidentType=" + incidentType + ", incidentDate="
				+ incidentDate + ", desc=" + desc + ", incidentStatus=" + incidentStatus + ", user=" + user + ", image="
				+ image + "]";
	}
}
