package com.shopping.mart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.mart.entity.ProductEntity;
import com.shopping.mart.mapper.ProductMapping;
import com.shopping.mart.model.Product;
import com.shopping.mart.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	
	public void setProducts(Product product)
	{
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(product.getName());
		productEntity.setCategory(product.getCategory());
		productEntity.setPrice(product.getPrice());
		productEntity.setQuantity(product.getQuantity());
		productEntity.setType(product.getType());
		productEntity.setRating(product.getRating());
		
		productRepo.save(productEntity);
		
	}
	
	public List<Product> getProducts()
	{
		List<ProductEntity> productEntityList = productRepo.findAll();
		List<Product>  productList = new ArrayList<>();

		for(ProductEntity productEntity : productEntityList )
		{
			Product product = new Product();
			
			product.setName(productEntity.getName());
			product.setCategory(productEntity.getCategory());
			product.setPrice(productEntity.getPrice());
			product.setQuantity(productEntity.getQuantity());
			product.setRating(productEntity.getRating());
			product.setType(productEntity.getType());
			product.setId(productEntity.getId());
			
			productList.add(product);
			
		}
		return productList; 
	}
	
	public void updateRating(Long pid, int rating)
	{
		List<ProductEntity> productEntityList = productRepo.findAllById(pid);
		for(ProductEntity productEntity : productEntityList )
		{
			productEntity.setRating(rating);
			productRepo.save(productEntity);
		}
		
	}
	
	public List<Product> filterDataByCategorys(String filterBy)
	{
		List<ProductEntity> productEntityList = productRepo.findAllByCategory(filterBy);
		List<Product>  productList = new ArrayList<>();

		for(ProductEntity productEntity : productEntityList )
		{
			Product product = new Product();
			
			product.setName(productEntity.getName());
			product.setCategory(productEntity.getCategory());
			product.setPrice(productEntity.getPrice());
			product.setQuantity(productEntity.getQuantity());
			product.setRating(productEntity.getRating());
			product.setType(productEntity.getType());
			product.setId(productEntity.getId());
			
			productList.add(product);
			
		}
		return productList; 
		//return products.stream().filter(product ->product.getCategory().equalsIgnoreCase(category)).findFirst().get();
	}
	
	public List<Product> filterDataByTypes(String filterBy)
	{
		List<ProductEntity> productEntityList = productRepo.findAllByType(filterBy);
		List<Product>  productList = new ArrayList<>();

		for(ProductEntity productEntity : productEntityList )
		{
			Product product = new Product();
			
			product.setName(productEntity.getName());
			product.setCategory(productEntity.getCategory());
			product.setPrice(productEntity.getPrice());
			product.setQuantity(productEntity.getQuantity());
			product.setRating(productEntity.getRating());
			product.setType(productEntity.getType());
			product.setId(productEntity.getId());
			
			productList.add(product);
			
		}
		return productList; 
		//return products.stream().filter(product ->product.getCategory().equalsIgnoreCase(category)).findFirst().get();
	}
	
	public List<Product> filterByRating(int rating)
	{
		List<ProductEntity> productEntityList = productRepo.findAllByRating(rating);
		List<Product>  productList = new ArrayList<>();
		for(ProductEntity productEntity : productEntityList )
		{
			Product product = new Product();
				
			product.setName(productEntity.getName());
			product.setCategory(productEntity.getCategory());
			product.setPrice(productEntity.getPrice());
			product.setQuantity(productEntity.getQuantity());
			product.setRating(productEntity.getRating());
			product.setType(productEntity.getType());
			product.setId(productEntity.getId());
			
			productList.add(product);
			
		}
		return productList; 
	}
	
	public List<Product> filterByAvailabilty()
	{
		List<ProductEntity> productEntityList = productRepo.findAll();
		List<Product>  productList = new ArrayList<>();
		for(ProductEntity productEntity : productEntityList )
		{
			Product product = new Product();
			
			if(productEntity.getQuantity()>0)
			{
				product.setName(productEntity.getName());
				product.setCategory(productEntity.getCategory());
				product.setPrice(productEntity.getPrice());
				product.setQuantity(productEntity.getQuantity());
				product.setRating(productEntity.getRating());
				product.setType(productEntity.getType());
				product.setId(productEntity.getId());
				
				productList.add(product);
			}
		}
		return productList; 
	}
	
	
	
	
	

}
