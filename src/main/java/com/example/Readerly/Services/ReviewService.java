package com.example.Readerly.Services;

import com.example.Readerly.DTO.Convert.EditReviewDTOtoReview;
import com.example.Readerly.DTO.Convert.ReviewDTOToReview;
import com.example.Readerly.DTO.EditReviewRequest;
import com.example.Readerly.DTO.ReviewRequest;
import com.example.Readerly.Entities.Review;
import com.example.Readerly.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //edit a review
    public void editReview(String reviewId, EditReviewRequest review) {
        Review rw = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Unexpected error occurred"));
        Review newRw = EditReviewDTOtoReview.toReview(review, rw);
        reviewRepository.save(newRw);
    }

    //Delete a review
    public void deleteReview(String reviewId) {
        try{
            reviewRepository.deleteById(reviewId);
        }catch (Exception e) {
            throw new RuntimeException("Unexpected error occurred");
        }
    }

    //Get all reviews for a book
    public List<Review> getReviewsByBook(String bookId) {
        try{
            return reviewRepository.findByBookId(bookId);
        }catch (Exception e) {
            throw new RuntimeException("Unexpected error occurred");
        }
    }
}
