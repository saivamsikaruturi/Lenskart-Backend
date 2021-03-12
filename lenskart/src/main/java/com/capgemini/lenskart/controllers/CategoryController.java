package com.capgemini.lenskart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lenskart.models.Category;
import com.capgemini.lenskart.models.dto.CategoryUpdateDto;
import com.capgemini.lenskart.service.CategoryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * This method will display all the categories
	 * 
	 * @return display list of all the products in the database.
	 */
	
	@GetMapping(value = "/categories")
	public ResponseEntity<Object> getCategory() {
        return new ResponseEntity<>(categoryService.getAllCategoryDetails(), HttpStatus.OK);
    }
	
	/**
	 * The method will search the particular category based on the input category id given by the user
	 * 
	 * @param categoryId
	 * @return display Category object of that particular id
	 */

	@GetMapping(value = "/category/{categoryId}")
	public ResponseEntity<Object> getCategoryById(@PathVariable Long categoryId){
		return new ResponseEntity<>(categoryService.getCategoryId(categoryId), HttpStatus.OK);
		
	}
	
	/**
	 * The method will insert a category with its name in the database
	 * 
	 * @param category
	 * @return the inserted category object 
	 */
	
	@PostMapping(value = "/insertCategory")
	public ResponseEntity<Category> insertCategory(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.insertCategory(category),HttpStatus.OK);
	}
	
	/**
	 * The method will update the category fields based on the given category id
	 * 
	 * @param categoryId
	 * @param categoryUpdateDto
	 * @return display the updated category fields
	 */
	
	@PutMapping(value = "/updateCategory") 
	public ResponseEntity<Category> updateCategory(@RequestBody CategoryUpdateDto categoryUpdateDto) {
		return new ResponseEntity<Category>(categoryService.updateCategory(categoryUpdateDto),HttpStatus.OK);
	}
	
	/**
	 * This method will delete the category object mapped with the given category id input
	 * 
	 * @param categoryId
	 * @return Show a success status after deleting the category successfully
	 */
	
	@DeleteMapping(value = "/deleteCategory/{categoryId}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("categoryId") Long categoryId) {
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * This method will delete all the categories present in the database
	 * 
	 * @return it will give a success status after deleting all the categories present in the database
	 */
	
	@DeleteMapping(value = "/deleteCategory")
	public ResponseEntity<Void> deleteCategory() {
		categoryService.deleteCategory();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * This method will delete the specific category present in the database
	 * 
	 * @return it will give a success status after deleting the category present in the database
	 */
	
	@DeleteMapping(value = "/deleteCategoryObject")
    public ResponseEntity<Category> deleteCategory(@RequestBody Category category) {
        categoryService.removeCategory(category);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
