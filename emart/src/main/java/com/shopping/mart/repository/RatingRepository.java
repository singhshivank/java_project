package com.shopping.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.mart.entity.RatingEntity;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long>{

}
