package com.swamy.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.swamy.bindings.Payment;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {

	@PostMapping("/payment/save")
	public ResponseEntity<String> savePayment(@RequestBody Payment payment);
	
	@GetMapping("/payment/list")
	public ResponseEntity<List<Payment>>getAllPayments();
	
	@GetMapping("/payment/edit/{id}")
	public ResponseEntity<Payment>editPayment(@PathVariable Integer id);
}
