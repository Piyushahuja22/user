package com.instainsurance.insuranceappl.services;

import java.util.List;

import com.instainsurance.insuranceappl.exceptions.InsuranceException;
import com.instainsurance.insuranceappl.models.PaymentReceipt;


public interface PaymentReceiptServices {
	Boolean insertPaymentReceipt(PaymentReceipt paymentReceipt) throws InsuranceException;
	List<PaymentReceipt> getPaymentReceipts() throws InsuranceException;
}
