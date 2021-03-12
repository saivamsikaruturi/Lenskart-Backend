package com.capgemini.lenskart.service;

import java.util.List;

import com.capgemini.lenskart.models.Product;
import com.capgemini.lenskart.models.dto.ProductUpdateDto;

public interface ProductService {
	
	/**
	 * The method will display all the products
	 * 
	 * @return List of all the product in the database
	 */

	List<Product> getAllProductDetails();
	
	List<Product> getProducts();
	
	/**
	 * The method will search the particular product based on the input product id given by the user
	 * 
	 * @param productId
	 * @return display Product object of that particular id
	 */

	Product getByProductId(Long productId);
	
	/**
	 * The method will insert a product with its name in the database
	 * 
	 * @param product
	 * @return the inserted product object
	 */

	Product createProduct(Product product);
	
	/**
	 * This method will delete the product object mapped with the given product id input
	 * 
	 * @param productId
	 * @return Show a success status after deleting the specific product associated with the product id successfully from the database
	 */

	void deleteProduct(Long productId);
	
	/**
	 *  The method will update the product fields based on the given product id
	 * 
	 * @param productId
	 * @param productDto
	 * @return display the updated product fields
	 */

	Product updateProduct(long productId, ProductUpdateDto productDto);
	
	/**
	 * This method will delete all the product object present in the database
	 * 
	 * @param productId
	 * @return Show a success status after deleting all the product successfully from the database
	 */

	void deleteProduct();
	
	/**
	 * This method will delete the specific product object present in the database
	 * @param product
	 * @return Show a success status after deleting the product successfully from the database
	 */
	
	
	Product removeProduct(Product product);

	
}
