package com.instainsurance.insuranceappl.daos;

import java.util.List;

import com.instainsurance.insuranceappl.exceptions.InsuranceException;
import com.instainsurance.insuranceappl.models.PaymentReceipt;

public interface PaymentReceiptDao { 
	Boolean insertPaymentReceipt(PaymentReceipt paymentReceipt) throws InsuranceException;
	List<PaymentReceipt> getPaymentReceipts() throws InsuranceException;
	
}