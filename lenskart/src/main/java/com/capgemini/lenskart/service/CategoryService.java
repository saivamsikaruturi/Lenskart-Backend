package com.capgemini.lenskart.service;

import java.util.List;

import com.capgemini.lenskart.models.Category;
import com.capgemini.lenskart.models.dto.CategoryUpdateDto;

public interface CategoryService {
	
	/**
	 * This method will display all the categories
	 * 
	 * @return display list of all the products in the databse.
	 */

	List<Category> getAllCategoryDetails();
	
	/**
	 * The method will search the particular category based on the input category id given by the user
	 * 
	 * @param categoryId
	 * @return display Category object of that particular id
	 */

	Category getCategoryId(Long categoryId);
	
	/**
	 * The method will insert a category with its name in the database
	 * 
	 * @param category
	 * @return the inserted category object 
	 */

	Category insertCategory(Category category);
	
	/**
	 * The method will update the category fields based on the given category id
	 * 
	 * @param categoryId
	 * @param categoryUpdateDto
	 * @return display the updated category fields
	 */

	Category updateCategory(CategoryUpdateDto categoryUpdateDto);
	
	/**
	 * This method will delete the category object mapped with the given category id input
	 * 
	 * @param categoryId
	 * @return Show a success status after deleting the category successfully
	 */

	void deleteCategory(Long categoryId);
	
	/**
	 * This method will delete all the categories present in the database
	 * 
	 * @return it will give a success status after deleting all the categories present in the database
	 */

	void deleteCategory();
	
    Category removeCategory(Category category);


}
