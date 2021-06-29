package com.Gangof5.ecommerce.controller;

import com.Gangof5.ecommerce.common.ApiResponse;
import com.Gangof5.ecommerce.dto.cart.AddToCartDto;
import com.Gangof5.ecommerce.dto.cart.CartDto;
import com.Gangof5.ecommerce.exceptions.AuthenticationFailException;
import com.Gangof5.ecommerce.exceptions.CartItemNotExistException;
import com.Gangof5.ecommerce.exceptions.ProductNotExistException;
import com.Gangof5.ecommerce.model.*;
import com.Gangof5.ecommerce.service.AuthenticationService;
import com.Gangof5.ecommerce.service.CartService;
import com.Gangof5.ecommerce.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token) throws AuthenticationFailException, ProductNotExistException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
      //  Book product = bookService.getProductById(addToCartDto.getProductId());
        Book book= bookService.getBook(addToCartDto.getBookId());
        System.out.println("book to add"+  book.getFileName());
        cartService.addToCart(addToCartDto, book, user);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        CartDto cartDto = cartService.listCartItems(user);
        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
    }
    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody AddToCartDto cartDto,
                                                      @RequestParam("token") String token) throws AuthenticationFailException,ProductNotExistException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        Book book = bookService.getBook(cartDto.getBookId());
        cartService.updateCartItem(cartDto, user,book);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID,@RequestParam("token") String token) throws AuthenticationFailException, CartItemNotExistException {
        authenticationService.authenticate(token);
        int userId = authenticationService.getUser(token).getId();
        cartService.deleteCartItem(itemID, userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }

}
