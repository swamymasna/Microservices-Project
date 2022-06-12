package com.swamy.bindings;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Payment {

	private Integer paymentId;
	private String paymentCode;
	private String paymentDesc;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
}

