package com.Gangof5.ecommerce.controller;


import com.Gangof5.ecommerce.common.ApiResponse;
import com.Gangof5.ecommerce.dto.product.BookDto;
import com.Gangof5.ecommerce.model.Book;
import com.Gangof5.ecommerce.model.User;
import com.Gangof5.ecommerce.model.WishList;
import com.Gangof5.ecommerce.service.AuthenticationService;
import com.Gangof5.ecommerce.service.BookService;
import com.Gangof5.ecommerce.service.WishListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

        @Autowired
        private WishListService wishListService;

        @Autowired
        private AuthenticationService authenticationService;

      @GetMapping("/{token}")
        public ResponseEntity<List<BookDto>> getWishList(@PathVariable("token") String token) {
                int user_id = authenticationService.getUser(token).getId();
                List<WishList> body = wishListService.readWishList(user_id);
                List<BookDto> books = new ArrayList<BookDto>();
                for (WishList wishList : body) {
                        books.add(BookService.getDtoFromBook(wishList.getBook()));
                }

                return new ResponseEntity<List<BookDto>>(books, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<ApiResponse> addWishList(@RequestBody Book product, @RequestParam("token") String token) {
                authenticationService.authenticate(token);
                User user = authenticationService.getUser(token);
                WishList wishList = new WishList(user, product);
                wishListService.createWishlist(wishList);
                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Add to wishlist"), HttpStatus.CREATED);

        }


}
