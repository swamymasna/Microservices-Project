package com.swamy.service;

import java.util.List;

import com.swamy.bindings.Order;

public interface IOrderService {

	public String saveOrder(Order order);
	
	public List<Order>getAllOrders();
	
	public Order getOneOrder(Integer oid);
	
	public String deleteOrder(Integer oid);
}

