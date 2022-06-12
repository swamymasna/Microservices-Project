package com.swamy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swamy.bindings.Payment;
import com.swamy.constants.AppConstants;
import com.swamy.entities.PaymentEntity;
import com.swamy.properties.AppProperties;
import com.swamy.repository.PaymentRepository;
import com.swamy.service.IPaymentService;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private AppProperties appProperties;

	@Override
	public String savePayment(Payment payment) {

		String result = null;

		PaymentEntity paymentEntity = new PaymentEntity();
		BeanUtils.copyProperties(payment, paymentEntity);
		PaymentEntity savedPayment = paymentRepository.save(paymentEntity);

		
		if (savedPayment.getPaymentId() != null) {
			result = appProperties.getMessages().get(AppConstants.PAYMENT_DATA_SAVED);
			
		}

		else {
			result = appProperties.getMessages().get(AppConstants.PAYMENT_DATA_NOT_SAVED);
			
		}

		return result;
	}

	@Override
	public List<Payment> getAllPayments() {

		List<Payment> list = new ArrayList<>();
		List<PaymentEntity> findAll = paymentRepository.findAll();

		for (PaymentEntity paymentEntity : findAll) {
			Payment payment = new Payment();
			BeanUtils.copyProperties(paymentEntity, payment);
			list.add(payment);
		}

		return list;
	}

	@Override
	public Payment getOnePayment(Integer paymentId) {

		Payment payment = new Payment();

		Optional<PaymentEntity> findById = paymentRepository.findById(paymentId);

		if (findById.isPresent()) {
			PaymentEntity paymentEntity = findById.get();
			payment = new Payment();
			BeanUtils.copyProperties(paymentEntity, payment);
		}

		return payment;
	}

	@Override
	public String deletePayment(Integer paymentId) {

		String message = null;
		
		paymentRepository.deleteById(paymentId);
		
		Map<String, String> messages = appProperties.getMessages();
		
		if(paymentId!=null) {
			message = appProperties.getMessages().get(AppConstants.DELETED_PAYMENT_DATA);
			
		}
		else {
			message = appProperties.getMessages().get(AppConstants.NOT_DELETED_PAYMENT_DATA);
			
		}
		
		return message;
	}

}
