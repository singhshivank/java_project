package com.shopping.mart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.mart.entity.CategoryEntity;
import com.shopping.mart.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public String addCategory(List<CategoryEntity> categoryList)
	{
		for(CategoryEntity category : categoryList)
		{
			categoryRepo.save(category);
		}
		return"category added";
	}

}
