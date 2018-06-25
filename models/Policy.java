package com.instainsurance.insuranceappl.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="policies")
public class Policy {
	
	@Id
	@Column(name = "policy_id")
	private String policyId;

	@Column(name = "policy_type")
	private String policyType;
	
	@Column(name = "policy_category")
	private String policyCategory;

	@Column(name = "policy_summary")
	private String policySummary;
	
	@Column(name = "description")
	private String desc;
	
	@Column(name = "validity_in_years")
	private Integer validityInYears ;

	public String getPolicyId() {
		return policyId;
	}

	public String getPolicySummary() {
		return policySummary;
	}

	public void setPolicySummary(String policySummary) {
		this.policySummary = policySummary;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getValidityInYears() {
		return validityInYears;
	}

	public void setValidityInYears(Integer validityInYears) {
		this.validityInYears = validityInYears;
	}

	
	public String getPolicyCategory() {
		return policyCategory;
	}

	public void setPolicyCategory(String policyCategory) {
		this.policyCategory = policyCategory;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyType=" + policyType + ", policyCategory=" + policyCategory
				+ ", policySummary=" + policySummary + ", desc=" + desc + ", validityInYears=" + validityInYears + "]";
	}
	
	

}
