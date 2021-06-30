package com.Gangof5.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gangof5.ecommerce.model.Review;
import com.Gangof5.ecommerce.service.ReviewService;



@RestController
@RequestMapping("/Review")
public class ReviewController {
	
	@Autowired
	ReviewService reviewServie;
	//http://localhost:8080/Review/AddReview/76d5072c-a7d8-46ee-9f40-2e2db6fc7323
	@PostMapping("/AddReview/{bookId}")
	public Review AddReview(@PathVariable String bookId, @RequestBody Review review) {

		return reviewServie.AddReview(bookId, review);
	}
	//http://localhost:8080/Review/GetReview/2
	@GetMapping("/GetReview/{idReview}")
	public Review GetReview(@PathVariable int idReview) {

		return reviewServie.DisplayReview(idReview);
	}
	
	//http://localhost:8080/Review/GetAllReviews
	
	@GetMapping("/GetAllReviews")
	public List<Review> GetReview() {

		return reviewServie.DisplayAllReviews();
	}
	//http://localhost:8080/Review/UpdateReview/2
	@PutMapping("/UpdateReview/{idReview}")
	public Review UpdateReview(@RequestBody Review r,@PathVariable int idReview) {

		return reviewServie.UpdateReview(r, idReview);
	}
	
	//http://localhost:8080/Review/DeleteReview/1
	@DeleteMapping("/DeleteReview/{ReviewId}")
	public int  AddReview(@PathVariable int ReviewId) {

		return reviewServie.RemoveReview(ReviewId);
	}


}
