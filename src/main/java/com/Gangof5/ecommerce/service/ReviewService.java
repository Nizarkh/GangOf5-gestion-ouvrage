package com.Gangof5.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gangof5.ecommerce.model.Book;
import com.Gangof5.ecommerce.model.Review;
import com.Gangof5.ecommerce.repository.BookRepository;
import com.Gangof5.ecommerce.repository.ReviewRepository;
@Service
public class ReviewService implements IReviewService{
	
	@Autowired ReviewRepository reviewRepository;
	@Autowired BookRepository bookRepository;


	@Override
	public Review AddReview(String IdBook, Review review) {
		Book b=bookRepository.getById(IdBook);
		Review R=new Review(review.getContent(), review.getRating(), b);
		
		reviewRepository.save(R);
		return R;
	}

	@Override
	public int RemoveReview(int idReview) {
		reviewRepository.deleteById(idReview);
		return 60;
	}

	@Override
	public Review UpdateReview(Review review, int idReview) {
		Review R=reviewRepository.getById(idReview);
		R.setContent(review.getContent());
		R.setRating(review.getRating());
		reviewRepository.save(R);
		return R;
	}

	@Override
	public Review DisplayReview(int idReview) {
		return reviewRepository.findById(idReview).get();
	}

	@Override
	public List<Review> DisplayAllReviews() {
		return reviewRepository.findAll();
	}

}
