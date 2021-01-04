package com.jpisistemas.jpideliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpisistemas.jpideliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
