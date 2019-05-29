package com.shopping.mart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.mart.entity.CartEntity;
import com.shopping.mart.model.Cart;
import com.shopping.mart.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepo;
	
	public void setCart(Long userId, Long productId)
	{
		CartEntity cartEntity = new CartEntity();
		cartEntity.setUserId(userId);
		cartEntity.setProductsId(productId);
		
		cartRepo.save(cartEntity);
	}
	
	
	public List<Cart> getCart(Long userId)
	{
		List<CartEntity> cartEntityList = cartRepo.findAllByUserId(userId);
		List<Cart> cartList = new ArrayList<>();

		for(CartEntity cartEntity : cartEntityList )
		{
			Cart cart = new Cart();
			
			cart.setId(cartEntity.getId());
			cart.setProductId(cartEntity.getProductsId());
			cart.setUserId(cartEntity.getUserId());
			
			cartList.add(cart);	
		}
		return cartList;
	}
	
}
