package com.example.Readerly.DTO.Convert;

import com.example.Readerly.DTO.ReviewResponse;
import com.example.Readerly.Entities.Review;

public class ReviewToReviewResponse {
    public static ReviewResponse convert(Review review, String name) {
        ReviewResponse reviewDTO = new ReviewResponse();
        reviewDTO.bookId = review.getBookId();
        reviewDTO.userId = review.getUserId();
        reviewDTO.user = name;
        reviewDTO.review = review.getReview();
        reviewDTO.rate = review.getRate();
        return reviewDTO;
    }
}
