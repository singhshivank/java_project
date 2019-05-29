package com.shopping.mart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.mart.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	List<ProductEntity> findAllById(Long pid);

	List<ProductEntity> findAllByCategory(String filterBy);

	List<ProductEntity> findAllByType(String filterBy);

	List<ProductEntity> findAllByRating(int rating);

	List<ProductEntity> findAllByUserId(Long userId);

	

	

}
