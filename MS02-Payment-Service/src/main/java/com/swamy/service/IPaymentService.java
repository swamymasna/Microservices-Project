package com.swamy.service;

import java.util.List;

import com.swamy.bindings.Payment;

public interface IPaymentService {

	public String savePayment(Payment payment);
	
	public List<Payment>getAllPayments();
	
	public Payment getOnePayment(Integer paymentId);

	public String deletePayment(Integer paymentId);
	
}

