package com.Gangof5.ecommerce.service;

import java.util.List;

import com.Gangof5.ecommerce.model.Review;

public interface IReviewService {
	
	public Review AddReview(String IdBook,Review review);
    public int RemoveReview(int idReview);
    public Review UpdateReview(Review review,int idReview);
    public Review DisplayReview(int idReview);
    public List<Review> DisplayAllReviews();

}
