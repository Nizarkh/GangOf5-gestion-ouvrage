package com.Gangof5.ecommerce.service;

import java.util.List;

import com.Gangof5.ecommerce.model.Review;

public interface IReviewService {
	
	public Review AddReview(String IdBook,Review review,String token);
    public int RemoveReview(int idReview,String token);
    public Review UpdateReview(Review review,int idReview,String token);
    public Review DisplayReview(int idReview,String token);
    public List<Review> DisplayAllReviews();

}
