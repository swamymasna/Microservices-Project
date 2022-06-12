package com.swamy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.bindings.Payment;
import com.swamy.service.IPaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {

	@Autowired
	private IPaymentService paymentService;
	
	@PostMapping("/save")
	public ResponseEntity<String> savePayment(@RequestBody Payment payment) {
		return new ResponseEntity<String>(paymentService.savePayment(payment), HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Payment>>getAllPayments(){
		return new ResponseEntity<>(paymentService.getAllPayments(), HttpStatus.OK);
	}
	
	@GetMapping("/edit/{id}")
	public ResponseEntity<Payment>editPayment(@PathVariable Integer id){
		return new ResponseEntity<Payment>(paymentService.getOnePayment(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deletePayment(@PathVariable Integer id){
		return new ResponseEntity<String>(paymentService.deletePayment(id), HttpStatus.OK);
	}
}
