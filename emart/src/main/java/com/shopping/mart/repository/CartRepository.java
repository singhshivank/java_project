package com.shopping.mart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.mart.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long>{

	List<CartEntity> findAllByUserId(Long userId);

}
