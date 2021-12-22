package com.eci.training.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eci.training.domain.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {

}
