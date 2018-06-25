package com.instainsurance.insuranceappl.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quotes")
public class Quote {
	@Id
	@Column(name = "quote_id")
	private String quoteId;
	
	@Column(name = "valid_from_date")
	private Date validFromDate;
	
	@Column(name = "valid_till_date")
	private Date validTillDate;
	
	@Column(name = "description")
	private String desc;
	
	@Column(name = "product_type")
	private String productType;
	
	@Column(name = "coverage_level")
	private String coverageLevel;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	public String getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(String quoteId) {
		this.quoteId = quoteId;
	}

	public Date getValidFromDate() {
		return validFromDate;
	}

	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	public Date getValidTillDate() {
		return validTillDate;
	}

	public void setValidTillDate(Date validTillDate) {
		this.validTillDate = validTillDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getCoverageLevel() {
		return coverageLevel;
	}

	public void setCoverageLevel(String coverageLevel) {
		this.coverageLevel = coverageLevel;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Quote [quoteId=" + quoteId + ", validFromDate=" + validFromDate + ", validTillDate=" + validTillDate
				+ ", desc=" + desc + ", productType=" + productType + ", coverageLevel=" + coverageLevel + ", customer="
				+ customer + "]";
	}

	
}

