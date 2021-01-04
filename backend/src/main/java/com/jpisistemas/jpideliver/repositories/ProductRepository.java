package com.jpisistemas.jpideliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpisistemas.jpideliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findAllByOrderByNameAsc();
}
