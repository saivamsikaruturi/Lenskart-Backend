package com.capgemini.lenskart.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenskart.constants.LenskartConstants;
import com.capgemini.lenskart.exceptions.EntityAlreadyExistsException;
import com.capgemini.lenskart.exceptions.NotFoundException;
import com.capgemini.lenskart.models.Product;
import com.capgemini.lenskart.models.dto.ProductUpdateDto;
import com.capgemini.lenskart.repository.ProductRepository;
import com.capgemini.lenskart.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	
	/**
	 * This method will delete the product object mapped with the given product id input
	 * 
	 * @param productId
	 * @return Show a success status after deleting all the product successfully from the database
	 */

	@Override
	public List<Product> getAllProductDetails() {
		return productRepository.findAll();
	}
	
	@Override
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}
	
	/**
	 * The method will search the particular product based on the input product id given by the user
	 * 
	 * @param productId
	 * @return display Product object of that particular id
	 */

	@Override
	public Product getByProductId(Long productId) {
		Optional<Product> optionalEntity = productRepository.findById(productId);
		if (optionalEntity.isPresent()) {
			return optionalEntity.get();
		} else {
			throw new NotFoundException(LenskartConstants.PRODUCT_NOT_FOUND);
		}

	}
	
	/**
	 * The method will insert a product with its name in the database
	 * 
	 * @param product
	 * @return the inserted product object 
	 */

	@Override
	public Product createProduct(Product productDto) {

		Optional<Product> optionalProduct = productRepository.findById(productDto.getProductId());

		if (!optionalProduct.isPresent()) {
			Product product = new Product();
			product.setProductId(productDto.getProductId());
			product.setProductName(productDto.getProductName());
			product.setProductDescription(productDto.getProductDescription());

			return productRepository.save(product);
		} else {
			throw new EntityAlreadyExistsException(LenskartConstants.PRODUCT_ALREADY_EXISTS);
		}

	}
	
	/**
	 * This method will delete the product object mapped with the given product id input
	 * 
	 * @param productId
	 * @return Show a success status after deleting the category successfully
	 */

	@Override
	public void deleteProduct(Long productId) {

		Optional<Product> optionalEntity = productRepository.findById(productId);
		if (optionalEntity.isPresent()) {
			productRepository.deleteById(productId);
		} else {
			throw new NotFoundException(LenskartConstants.PRODUCT_NOT_FOUND);
		}

	}
	
	/**
	 * This method will delete all the product object present in the database
	 * 
	 * @param productId
	 * @return Show a success status after deleting all the product successfully from the database
	 */
	
	@Override
	public void deleteProduct() {

		List<Product> products = productRepository.findAll();
		if (products.size() > 0) {
			productRepository.deleteAll();
		} else {
			throw new NotFoundException(LenskartConstants.PRODUCT_NOT_FOUND);
		}

	}
	
	@Override
    @Transactional
    public Product removeProduct(Product product) {
        productRepository.delete(product);
        return product;
    }
	
	/**
	 * The method will update the product fields based on the given product id
	 * 
	 * @param productId
	 * @param productUpdateDto
	 * @return display the updated product fields
	 */

	@Override
	public Product updateProduct(long productId, ProductUpdateDto productUpdateDto) {
		return productRepository.findById(productId).map(productEntity -> {
			productEntity.setProductName(productUpdateDto.getProductName());
			productEntity.setProductDescription(productUpdateDto.getProductDescription());
			return productRepository.save(productEntity);
		}).orElseThrow(() -> new NotFoundException(LenskartConstants.PRODUCT_NOT_FOUND));
	}

}
