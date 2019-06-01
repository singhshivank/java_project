package com.shopping.mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.mart.model.Cart;
import com.shopping.mart.service.CartService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@GetMapping("/cart/{userId}")
	public List<Cart> getCartByUser(@PathVariable Long userId)
	{
		return cartService.getCart(userId);
	}
	
	@PostMapping("/cart/{userId}/{productId}")
	public void setProduct(@PathVariable Long userId, @PathVariable Long productId)
	{
		cartService.setCart(userId, productId);
	}
}
