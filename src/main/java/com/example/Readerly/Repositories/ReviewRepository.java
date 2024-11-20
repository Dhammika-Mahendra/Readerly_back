package com.example.Readerly.Repositories;

import com.example.Readerly.Entities.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
