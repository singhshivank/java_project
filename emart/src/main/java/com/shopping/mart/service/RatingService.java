package com.shopping.mart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.mart.entity.RatingEntity;
import com.shopping.mart.repository.RatingRepository;

@Service		
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepo;
	
	public String addRating( Long productId, Integer rating )
	{
		RatingEntity ratingEntity = new RatingEntity();
		ratingEntity.setProductId(productId);
		ratingEntity.setRating(rating);
		
		ratingRepo.save(ratingEntity);
		return "rating is added";
	}

}
