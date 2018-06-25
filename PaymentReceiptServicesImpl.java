package com.instainsurance.insuranceappl.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.instainsurance.insuranceappl.daos.PaymentReceiptDao;
import com.instainsurance.insuranceappl.exceptions.InsuranceException;
import com.instainsurance.insuranceappl.models.PaymentReceipt;
import com.instainsurance.insuranceappl.services.PaymentReceiptServices;


@Service
public class PaymentReceiptServicesImpl implements PaymentReceiptServices {

	@Resource
	private PaymentReceiptDao dao;
	
		@Override
	public Boolean insertPaymentReceipt(PaymentReceipt paymentReceipt) throws InsuranceException {
			return dao.insertPaymentReceipt(paymentReceipt);
	}

	@Override
	public List<PaymentReceipt> getPaymentReceipts() throws InsuranceException {
		return dao.getPaymentReceipts();
	}

}
