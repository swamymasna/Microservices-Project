package com.swamy.controller.rest;

import java.util.List;

import org.springframework.beans.BeanUtils;
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

import com.swamy.bindings.Order;
import com.swamy.bindings.Payment;
import com.swamy.client.PaymentClient;
import com.swamy.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderRestController {
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private PaymentClient paymentClient;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveOrder(@RequestBody Order order) {
		paymentClient.editPayment(order.getPob().getPaymentId()).getBody();
		return new ResponseEntity<String>(orderService.saveOrder(order), HttpStatus.CREATED); 
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Order>> listOrder() {
		return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK); 
	}
	
	@GetMapping("/edit/{id}")
	public ResponseEntity<Order> editOrder(@PathVariable Integer id) {
		return new ResponseEntity<>(orderService.getOneOrder(id), HttpStatus.OK); 
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Integer id) {
		return new ResponseEntity<>(orderService.deleteOrder(id), HttpStatus.OK); 
	}
}


