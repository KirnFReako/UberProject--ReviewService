package com.example.UberReviewService.service;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.ReviewRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("********");
        Review r = Review.builder()
                .content("Amazing ride Quality")
                .rating(4.0)
                .build();
        Review savedReview = reviewRepository.save(r);
        System.out.println(savedReview);
    }
}
