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
@Table(name = "premium_payment_receipt")
public class PaymentReceipt {

	@Id
	@Column(name = "premium_payment_receipt_id")
	private String paymentReceiptId;

	@Column(name = "policy_number")
	private String policyNumber;
	
	@Column(name = "premium_payment_amount")
	private Double paymentAmount;
	
	@Column(name = "premium_payment_schedule")
	private Date paymentSchedule;
	
	@Column(name = "time")
	private Date time;
	
	@Column(name = "user_id")
	private User user;

	public PaymentReceipt() {
		super();
		
	}

	public String getPaymentReceiptId() {
		return paymentReceiptId;
	}

	public void setPaymentReceiptId(String paymentReceiptId) {
		this.paymentReceiptId = paymentReceiptId;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Date getPaymentSchedule() {
		return paymentSchedule;
	}

	public void setPaymentSchedule(Date paymentSchedule) {
		this.paymentSchedule = paymentSchedule;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PaymentReceipt [paymentReceiptId=" + paymentReceiptId + ", policyNumber=" + policyNumber
				+ ", paymentAmount=" + paymentAmount + ", paymentSchedule=" + paymentSchedule + ", time=" + time
				+ ", user=" + user + "]";
	}

	
    




}
