package com.example.Readerly.Services;

import com.example.Readerly.DTO.Convert.ReviewDTOToReview;
import com.example.Readerly.DTO.ReviewRequest;
import com.example.Readerly.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    //Post a review
    public void postReview(ReviewRequest review) {
        reviewRepository.save(ReviewDTOToReview.toReview(review));
    }
}
