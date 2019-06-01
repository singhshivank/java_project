package com.shopping.mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.mart.entity.CategoryEntity;
import com.shopping.mart.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryServce;
	
	@PostMapping("products/category")
	public String addCategory(@RequestBody List<CategoryEntity> categoryList)
	{
		return categoryServce.addCategory(categoryList); 
	}
}
