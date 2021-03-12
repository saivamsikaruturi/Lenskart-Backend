package com.capgemini.lenskart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.lenskart.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("Select p from Product p")
	public List<Product> getProducts();
}
