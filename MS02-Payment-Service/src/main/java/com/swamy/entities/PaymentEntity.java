package com.swamy.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "PAYMENT_TBL")
public class PaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAYMENT_ID")
	private Integer paymentId;
	
	@Column(name = "PAYMENT_CODE")
	private String paymentCode;
	
	@Column(name = "PAYMENT_DESC")
	private String paymentDesc;
	
	@CreationTimestamp
	@Column(name = "PAYMENT_CREATED_DATE")
	private LocalDateTime createdDate;

	@UpdateTimestamp
	@Column(name = "PAYMENT_UPDATED_DATE")
	private LocalDateTime updatedDate;
}
