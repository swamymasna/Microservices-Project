package com.swamy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swamy.bindings.Order;
import com.swamy.constants.AppConstants;
import com.swamy.entities.OrderEntity;
import com.swamy.properties.AppProperties;
import com.swamy.repository.OrderRepository;
import com.swamy.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private AppProperties appProperties;
	
	@Override
	public String saveOrder(Order order) {
	
		String result = null;
		OrderEntity orderEntity = new OrderEntity();
		BeanUtils.copyProperties(order, orderEntity);
		OrderEntity savedOrder = orderRepository.save(orderEntity);
		
		if(savedOrder.getOrderId() != null) {
			result = appProperties.getMessages().get(AppConstants.ORDER_SAVED);
			
		}
		else {
			result = appProperties.getMessages().get(AppConstants.ORDER_NOT_SAVED);
			
		}
		
		return result;
	}

	@Override
	public List<Order> getAllOrders() {
		
		List<Order> list = new ArrayList<>();
		List<OrderEntity> findAll = orderRepository.findAll();
		
		for (OrderEntity orderEntity : findAll) {
			Order order = new Order();
			BeanUtils.copyProperties(orderEntity, order);
			list.add(order);
		}
		
		return list;
	}

	@Override
	public Order getOneOrder(Integer oid) {
		Order order = null;
		Optional<OrderEntity> findById = orderRepository.findById(oid);
		
		if(findById.isPresent()) {
			OrderEntity orderEntity = findById.get();
			order = new Order();
			BeanUtils.copyProperties(orderEntity, order);
		}
		
		return order;
	}

	@Override
	public String deleteOrder(Integer oid) {
		
		String message = null;
		orderRepository.deleteById(oid);
		
		if(oid != null) {
			message = appProperties.getMessages().get(AppConstants.ORDER_DELETED);
		}
		
		else{
			message = appProperties.getMessages().get(AppConstants.ORDER_NOT_DELETED);
		}
		
		return message;
	}

}
