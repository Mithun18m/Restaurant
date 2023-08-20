package com.mindtree.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.review.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer>
{

	List<Review> findByRestaurantId(String restaurantId);

	public void save(ReviewRepository reviewRepo);

}
