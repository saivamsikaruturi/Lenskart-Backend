package com.capgemini.lenskart;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.lenskart.models.Category;
import com.capgemini.lenskart.models.Product;
import com.capgemini.lenskart.models.dto.CategoryUpdateDto;
import com.capgemini.lenskart.models.dto.ProductUpdateDto;
import com.capgemini.lenskart.repository.CategoryRepository;
import com.capgemini.lenskart.repository.ProductRepository;
import com.capgemini.lenskart.service.CategoryService;
import com.capgemini.lenskart.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
class LenskartApplicationTests {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	@MockBean
	CategoryRepository categoryRespository;
	@MockBean
	ProductRepository productRepository;

	Category category = null;
	Product product = null;
	
	/**
	 * Before each test case it will initialize the category and product object
	 */

	@BeforeEach
	public void beforeEachTestMethod() {

		category = new Category();
		category.setCategoryId(1L);
		category.setCategoryName("CategoryTest");

		List<Product> productDetails = new ArrayList<>();
		productDetails.add(new Product(1L, "productNameTest1", "productDescTest1"));
		productDetails.add(new Product(2L, "productNameTest2", "productDescTest2"));

		category.setProduct(productDetails);
		
		product = new Product();
		product.setProductId(1L);
		product.setProductName("Product 1");
		product.setProductDescription("Product 1 desc");
	}

	
	/**
	 * Test case for viewing all the category present
	 */

	@Test
	public void testGetCategories() {

		when(categoryRespository.findAll()).thenReturn(Stream.of(category).collect(Collectors.toList()));

		assertEquals(1, categoryService.getAllCategoryDetails().size());
		assertEquals("productNameTest1",
				categoryService.getAllCategoryDetails().get(0).getProduct().get(0).getProductName());
	}
	
	/**
	 * Test case to insert a category object
	 */

	@Test
	public void testInsertCategory() {

		when(categoryRespository.save(category)).thenReturn(category);

		assertEquals(category, categoryService.insertCategory(category));

	}
	
	/**
	 * Test case for update category
	 */

	@Test
	public void testUpdateCategory() {

		Category updateCategory = new Category(1L, "Computer Glasses", category.getProduct());
		CategoryUpdateDto categoryUpdateDto = new CategoryUpdateDto(1L, "Updated Computer Glasses",
				category.getProduct());

		when(categoryRespository.findById(1L)).thenReturn(Optional.of(updateCategory));

		when(categoryRespository.save(updateCategory)).thenReturn(updateCategory);

		assertEquals("Updated Computer Glasses", categoryService.updateCategory(categoryUpdateDto).getCategoryName());

	}
	
	/**
	 * Test case for deleting a category object
	 */

	@Test
	public void testDeleteCategory() {

		categoryService.removeCategory(category);
		verify(categoryRespository, times(1)).delete(category);
	}
	
	/**
	 * Test case for viewing all the products in the database
	 */

	@Test
	public void testGetAllProductDetails() {

		when(productRepository.findAll()).thenReturn(Stream.of(product).collect(Collectors.toList()));

		assertEquals(1, productService.getAllProductDetails().size());
		assertEquals("Product 1", productService.getAllProductDetails().get(0).getProductName());

	}
	
	/**
	 * Test case for inserting a product
	 */

	@Test
	public void testCreateProduct() {

		when(productRepository.save(product)).thenReturn(product);

		assertEquals(product, productService.createProduct(product));

	}
	
	/**
	 * Test case for deleting a product object
	 */

	@Test
	public void testDeleteProduct() {

		productService.removeProduct(product);
		verify(productRepository, times(1)).delete(product);

	}
	
	/**
	 * Test case for updating a product
	 */

	@Test
	public void testUpdateProduct() {

		Product product4 = new Product();
		ProductUpdateDto productDto = new ProductUpdateDto("old glasses", "old desc");
		
		when(productRepository.findById(1L)).thenReturn(Optional.of(product4));
		product4.setProductName("New glasses");
		
		when(productRepository.save(product4)).thenReturn(product4);
		
		assertThat(productService.updateProduct(1L, productDto)).isEqualTo(product4);

	}

}
