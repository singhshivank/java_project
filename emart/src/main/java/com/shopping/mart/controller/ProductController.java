package com.shopping.mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.mart.model.Product;
import com.shopping.mart.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/emart")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products/list")
	public List<Product> get()
	{
		return productService.getProducts();
	}
	
	@PostMapping("/products/add")
	public List<Product> setProduct(@RequestBody() Product product)
	{
		productService.setProducts(product);
		return productService.getProducts();
	}
	
	@PutMapping("/products/{productId}/{rating}")
	public List<Product> updateRating(@PathVariable Long productId, @PathVariable int rating )
	{
		productService.updateRating(productId, rating);
		return productService.getProducts();
	}
	
	@GetMapping("/products/cat/{filterBy}")  //http://localhost:8080/emart//products/cat/phone
	public List<Product> filterDataByCat(@PathVariable String filterBy)
	{
		return productService.filterDataByCategorys(filterBy);
	}
	
	@GetMapping("/products/type/{filterBy}")  //http://localhost:8080/emart/product/type/men
	public List<Product> filterDatabyType(@PathVariable String filterBy)
	{
		return productService.filterDataByTypes(filterBy);
	}
	
	@GetMapping("/products/rating/{rating}")  //http://localhost:8080/emart/product/type/men
	public List<Product> filterDatabyRating(@PathVariable int rating)
	{
		return productService.filterByRating(rating);
	}
	
	@GetMapping("/products/avl")  //http://localhost:8080/emart/product/type/men
	public List<Product> filterDatabyAvl()
	{
		return productService.filterByAvailabilty();
	}
	
	

}
