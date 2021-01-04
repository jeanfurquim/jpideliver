package com.jpisistemas.jpideliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpisistemas.jpideliver.dto.OrderDto;
import com.jpisistemas.jpideliver.dto.ProductDto;
import com.jpisistemas.jpideliver.entities.Order;
import com.jpisistemas.jpideliver.entities.OrderStatus;
import com.jpisistemas.jpideliver.entities.Product;
import com.jpisistemas.jpideliver.repositories.OrderRepository;
import com.jpisistemas.jpideliver.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<OrderDto> findAll() {
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());

	}

	@Transactional
	public OrderDto insert(OrderDto dto) {
		
		Order order = new Order(null,dto.getAddress(), dto.getLatitude(), dto.getLatitude(),Instant.now(),
				OrderStatus.PENDING);
		for(ProductDto p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = repository.save(order);
		return new OrderDto(order);
	}

	@Transactional
	public OrderDto setDelivered(Long id) {
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repository.save(order);
		return new OrderDto(order);
		
	}
}
