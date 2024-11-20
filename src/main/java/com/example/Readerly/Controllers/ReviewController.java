package com.example.Readerly.Controllers;

import com.example.Readerly.DTO.EditReviewRequest;
import com.example.Readerly.DTO.ReviewRequest;
import com.example.Readerly.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    //Create a new review
    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody ReviewRequest review) {
        try{
          reviewService.postReview(review);
          return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Editing a review
    @PutMapping("/{reviewId}")
    public ResponseEntity<?> editReview(@PathVariable String reviewId, @RequestBody EditReviewRequest review) {
        try{
          reviewService.editReview(reviewId,review);
          return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
