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
@Table(name = "claim")
public class Claim {

	@Id
	@Column(name = "claim_id")
	private String claimId;

	@Column(name = "claim_amount")
	private Double claimAmount;

	@OneToOne
	private IncidentReport incidentReport;

	@Column(name = "date_of_claim")
	private Date dateOfClaim;
	
	@Column(name = "incident_type")
	private String incidentType;

	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public Double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(Double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public IncidentReport getIncidentReport() {
		return incidentReport;
	}

	public void setIncidentReport(IncidentReport incidentReport) {
		this.incidentReport = incidentReport;
	}

	public Date getDateOfClaim() {
		return dateOfClaim;
	}

	public void setDateOfClaim(Date dateOfClaim) {
		this.dateOfClaim = dateOfClaim;
	}

	public String getIncidentType() {
		return incidentType;
	}

	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimAmount=" + claimAmount + ", incidentReport=" + incidentReport
				+ ", dateOfClaim=" + dateOfClaim + ", incidentType=" + incidentType + "]";
	}



}
