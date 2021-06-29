package com.Gangof5.ecommerce.controller;


import com.Gangof5.ecommerce.config.MessageResponse;
import com.Gangof5.ecommerce.dto.*;
import com.Gangof5.ecommerce.dto.user.SignInDto;
import com.Gangof5.ecommerce.dto.user.SignInResponseDto;
import com.Gangof5.ecommerce.dto.user.SignupDto;
import com.Gangof5.ecommerce.dto.user.UserCreateDto;
import com.Gangof5.ecommerce.dto.user.UserUpdateDto;
import com.Gangof5.ecommerce.enums.Role;
import com.Gangof5.ecommerce.exceptions.AuthenticationFailException;
import com.Gangof5.ecommerce.exceptions.CustomException;
import com.Gangof5.ecommerce.model.User;
import com.Gangof5.ecommerce.repository.UserRepository;
import com.Gangof5.ecommerce.service.AuthenticationService;
import com.Gangof5.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userService.GetAllUsers(token);
    }

    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    //TODO token should be updated
    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }

    @PostMapping("/updateUser")
    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserUpdateDto userUpdateDto) {
        authenticationService.authenticate(token);
       return userService.updateUser(token, userUpdateDto);
    }


    @PostMapping("/createUser")
    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserCreateDto userCreateDto)
            throws CustomException, AuthenticationFailException {
       authenticationService.authenticate(token);
        return userService.createUser(token, userCreateDto);
    }
    
    @GetMapping("/role")
    public List<User> findUserByRole(@RequestParam("token") String token, @RequestParam("role") Role role) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userService.GetUsersByRole(token, role);
    }
    @PostMapping("/logout")
	  public MessageResponse logoutUser( @RequestParam("token") String token) {
    	userService.logout(token);
    	return new MessageResponse("Log out successful!");
	  }
}
