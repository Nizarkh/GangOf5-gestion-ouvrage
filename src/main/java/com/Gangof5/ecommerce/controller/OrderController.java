package com.Gangof5.ecommerce.controller;

import com.Gangof5.ecommerce.common.ApiResponse;
import com.Gangof5.ecommerce.dto.cart.CartDto;
import com.Gangof5.ecommerce.dto.cart.CartItemDto;
import com.Gangof5.ecommerce.dto.checkout.CheckoutItemDto;
import com.Gangof5.ecommerce.dto.checkout.StripeResponse;
import com.Gangof5.ecommerce.dto.order.PlaceOrderDto;
import com.Gangof5.ecommerce.exceptions.AuthenticationFailException;
import com.Gangof5.ecommerce.exceptions.OrderNotFoundException;
import com.Gangof5.ecommerce.exceptions.ProductNotExistException;
import com.Gangof5.ecommerce.model.*;
import com.Gangof5.ecommerce.service.*;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> placeOrder(@RequestParam("token") String token, @RequestParam("sessionId") String sessionId)
            throws ProductNotExistException, AuthenticationFailException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        orderService.placeOrder(user, sessionId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Order has been placed"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        List<Order> orderDtoList = orderService.listOrders(user);
        return new ResponseEntity<List<Order>>(orderDtoList,HttpStatus.OK);
    }

    @PostMapping("/create-checkout-session")
    public ResponseEntity<StripeResponse> checkoutList(@RequestParam("token") String token) throws StripeException {
    	authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        CartDto cartDto = cartService.listCartItems(user);
    	List<CheckoutItemDto> checkoutItemDtoList = new ArrayList<CheckoutItemDto>();
    	for(CartItemDto c : cartDto.getcartItems())
    	{
    		CheckoutItemDto ch= new CheckoutItemDto(c.getBook().getFileName(), c.getQuantity(), c.getBook().getPrice(), c.getBook().getId(), user.getId());
    		checkoutItemDtoList.add(ch);
    	}
        Session session = orderService.createSession(checkoutItemDtoList);
        StripeResponse stripeResponse = new StripeResponse(session.getId());
        return new ResponseEntity<StripeResponse>(stripeResponse,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAllOrders(@PathVariable("id") Integer id, @RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        try {
            Order order = orderService.getOrder(id);
            return new ResponseEntity<>(order,HttpStatus.OK);
        }
        catch (OrderNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

}
