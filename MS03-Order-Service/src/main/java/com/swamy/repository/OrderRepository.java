package com.swamy.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swamy.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Serializable> {

}
