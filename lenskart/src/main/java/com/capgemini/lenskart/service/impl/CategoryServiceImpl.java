package com.capgemini.lenskart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenskart.constants.LenskartConstants;
import com.capgemini.lenskart.exceptions.NotFoundException;
import com.capgemini.lenskart.models.Category;
import com.capgemini.lenskart.models.Product;
import com.capgemini.lenskart.models.dto.CategoryUpdateDto;
import com.capgemini.lenskart.repository.CategoryRepository;
import com.capgemini.lenskart.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class CategoryServiceImpl implements CategoryService{
	
	private final CategoryRepository categoryRepository; 
	
	/**
	 * This method will display all the categories
	 * 
	 * @return display list of all the categories in the database.
	 */

	@Override
	public List<Category> getAllCategoryDetails() {
		return categoryRepository.findAll();
		
	}
	
	/**
	 * The method will search the particular category based on the input category id given by the user
	 * 
	 * @param categoryId
	 * @return display Category object of that particular id
	 */
	
	@Override
	public Category getCategoryId(Long categoryId) {
		
			Optional<Category> entity =  categoryRepository.findById(categoryId);
			if(entity.isPresent()) {
				return entity.get();
			}
			else {
				throw new NotFoundException(LenskartConstants.CATEGORY_NOT_FOUND);

			}
	}
	
	/**
	 * The method will insert a category with its name in the database
	 * 
	 * @param category
	 * @return the inserted category object 
	 */
	
	@Override
	public Category insertCategory(Category categoryDto) {
			
			return categoryRepository.save(categoryDto);
	
	}
	
	/**
	 * The method will update the category fields based on the given category id
	 * 
	 * @param categoryId
	 * @param categoryUpdateDto
	 * @return display the updated category fields
	 */
	
	@Override
	public Category updateCategory(CategoryUpdateDto categoryUpdateDto) {
		
		return categoryRepository.findById(categoryUpdateDto.getCategoryId()).map(categoryEntity -> {
            categoryEntity.setCategoryName(categoryUpdateDto.getCategoryName());
            List<Product> productList = new ArrayList<>();
            for (int i = 0; i < categoryUpdateDto.getProductList().size(); i++) {
                Product product = new Product();
                product.setProductId(categoryUpdateDto.getProductList().get(i).getProductId());
                product.setProductName(categoryUpdateDto.getProductList().get(i).getProductName());
                product.setProductDescription(categoryUpdateDto.getProductList().get(i).getProductDescription());
                productList.add(product);

                categoryEntity.setProduct(productList);
            }
            return categoryRepository.save(categoryEntity);
        }).orElseThrow(() -> new NotFoundException(LenskartConstants.CATEGORY_NOT_FOUND));
		
	}
	
	/**
	 * This method will delete the category object mapped with the given category id input
	 * 
	 * @param categoryId
	 * @return Show a success status after deleting the category successfully
	 */
	
	@Override
	public void deleteCategory(Long categoryId) {

		Optional<Category> optionalEntity = categoryRepository.findById(categoryId);
		if (optionalEntity.isPresent()) {
			categoryRepository.deleteById(categoryId);
		} else {
			throw new NotFoundException(LenskartConstants.CATEGORY_NOT_FOUND);
		}

	}
	
	/**
	 * This method will delete all the categories present in the database
	 * 
	 * @return it will give a success status after deleting all the categories present in the database
	 */
	
	@Override
	public void deleteCategory() {
		List<Category> categories = categoryRepository.findAll();

		if(categories.size()>0) {
			categoryRepository.deleteAll();
		}
		else {
			throw new NotFoundException(LenskartConstants.CATEGORY_NOT_FOUND);

		}

	}
	
	/**
	 * This method will delete the specific category present in the database
	 * 
	 * @return it will give a success status after deleting the category present in the database
	 */ 
	
    @Override
    @Transactional
    public Category removeCategory(Category category) {
        categoryRepository.delete(category);
        return category;
    }
}
