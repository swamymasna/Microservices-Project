package com.swamy.bindings;

import com.swamy.entities.PaymentEntity;

import lombok.Data;

@Data
public class Order {

	private Integer orderId;
	private String orderStatus;
	private String orderDesc;
	private PaymentEntity pob;
}
