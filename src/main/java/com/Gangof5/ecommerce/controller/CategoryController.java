package com.Gangof5.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Gangof5.ecommerce.common.ApiResponse;
import com.Gangof5.ecommerce.model.Category;
import com.Gangof5.ecommerce.service.CategoryService;
import com.Gangof5.ecommerce.utils.Helper;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> body = categoryService.listCategories();
        return new ResponseEntity<List<Category>>(body, HttpStatus.OK);
    }

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
		if (Helper.notNull(categoryService.readCategory(category.getCategoryName()))) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already exists"), HttpStatus.CONFLICT);
		}
		categoryService.createCategory(category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);
	}

	@PostMapping("/update/{categoryID}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") Integer categoryID,  @RequestBody Category category) {
		if (Helper.notNull(categoryService.readCategory(categoryID))) {
			categoryService.updateCategory(categoryID, category);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the category"), HttpStatus.OK);
		}

		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
	}
}
