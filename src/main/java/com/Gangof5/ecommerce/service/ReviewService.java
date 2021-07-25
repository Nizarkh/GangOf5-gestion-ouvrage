package com.Gangof5.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gangof5.ecommerce.model.Book;
import com.Gangof5.ecommerce.model.Review;
import com.Gangof5.ecommerce.model.User;
import com.Gangof5.ecommerce.repository.BookRepository;
import com.Gangof5.ecommerce.repository.ReviewRepository;
import com.Gangof5.ecommerce.repository.UserRepository;
@Service
public class ReviewService implements IReviewService{
	
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthenticationService authenticationService;

	// @Override
	// public Review AddReview(String IdBook, Review review) {
	// Book b=bookRepository.getById(IdBook);
	// Review R=new Review(review.getContent(), review.getRating(), b);
	//
	// reviewRepository.save(R);
	// return R;
	// }
	//
	// @Override
	// public int RemoveReview(int idReview) {
	// reviewRepository.deleteById(idReview);
	// return 60;
	// }
	//
	// @Override
	// public Review UpdateReview(Review review, int idReview) {
	// Review R=reviewRepository.getById(idReview);
	// R.setContent(review.getContent());
	// R.setRating(review.getRating());
	// reviewRepository.save(R);
	// return R;
	// }
	//
	// @Override
	// public Review DisplayReview(int idReview) {
	// return reviewRepository.findById(idReview).get();
	// }

	@Override
	public List<Review> DisplayAllReviews() {
		return reviewRepository.findAll();
	}

	@Override
	public Review AddReview(int IdBook, Review review, String token) {
		User user = authenticationService.getUser(token);
		List<User> users = new ArrayList<User>();
		users.add(user);
		Book b = bookRepository.getById(IdBook);
		Review R = new Review(review.getContent(), review.getRating(), b, users);

		reviewRepository.save(R);
		return R;
	}

	@Override
	public int RemoveReview(int idReview, String token) {
		User user = authenticationService.getUser(token);
		// List<User> listeDeUsersParIdReview(@Param("id") int id);
		//List<User> users = userRepository.listeDeUsersParIdReview(user.getId());
		// if (user in users)
		//for (User user2 : users) {
		//	if (user == user2)
				reviewRepository.deleteById(idReview);

		//}
		// reviewRepository.deleteById(idReview);
		return 60;
	}

	@Override
	public Review UpdateReview(Review review, int idReview) {
		//User user = authenticationService.getUser(token);
		// *List<User> listeDeUsersParIdReview(@Param("id") int id);
		//List<User> users = userRepository.listeDeUsersParIdReview(user.getId());
		// *if (user in users)
//		for (User user2 : users) {
//			if (user == user2) {
//				Review R = reviewRepository.getById(idReview);
//				R.setContent(review.getContent());
//				R.setRating(review.getRating());
//				reviewRepository.save(R);
//			}
			 Review R=reviewRepository.getById(idReview);
			 R.setContent(review.getContent());
			 R.setRating(review.getRating());
			 reviewRepository.save(R);
			 return R;

		//}
		//return review;
	}

	@Override
	public Review DisplayReview(int idReview, String token) {
		User user = authenticationService.getUser(token);
		return reviewRepository.findById(idReview).get();
	}

}
