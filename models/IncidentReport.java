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
@Table(name = "incidentReport")
public class IncidentReport {

	@Id
	@Column(name = "incident_report_id")
	private String incidentReportId;
	
	@Column(name = "incident_surveyor")
	private String incidentSurveyor;
	
	@Column(name = "incident_coverage")
	private Double incidentCoverage;
	
	@Column(name = "approval_status")
	private String approvalStatus;
	
	@OneToOne
	private Incident incident;

	
	
	public IncidentReport() {
		super();
	
	}

	public String getIncidentReportId() {
		return incidentReportId;
	}

	public void setIncidentReportId(String incidentReportId) {
		this.incidentReportId = incidentReportId;
	}

	public String getIncidentSurveyor() {
		return incidentSurveyor;
	}

	public void setIncidentSurveyor(String incidentSurveyor) {
		this.incidentSurveyor = incidentSurveyor;
	}

	public Double getIncidentCoverage() {
		return incidentCoverage;
	}

	public void setIncidentCoverage(Double incidentCoverage) {
		this.incidentCoverage = incidentCoverage;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@Override
	public String toString() {
		return "IncidentReport [incidentReportId=" + incidentReportId + ", incidentSurveyor=" + incidentSurveyor
				+ ", incidentCoverage=" + incidentCoverage + ", approvalStatus=" + approvalStatus + ", incident="
				+ incident + "]";
	}
	
	
}
