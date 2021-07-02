package com.Gangof5.ecommerce.service;

import com.Gangof5.ecommerce.config.MessageResponse;
import com.Gangof5.ecommerce.config.MessageStrings;
import com.Gangof5.ecommerce.dto.*;
import com.Gangof5.ecommerce.dto.user.SignInDto;
import com.Gangof5.ecommerce.dto.user.SignInResponseDto;
import com.Gangof5.ecommerce.dto.user.SignupDto;
import com.Gangof5.ecommerce.dto.user.UserCreateDto;
import com.Gangof5.ecommerce.dto.user.UserUpdateDto;
import com.Gangof5.ecommerce.enums.ResponseStatus;
import com.Gangof5.ecommerce.enums.Role;
import com.Gangof5.ecommerce.exceptions.AuthenticationFailException;
import com.Gangof5.ecommerce.exceptions.CustomException;
import com.Gangof5.ecommerce.model.AuthenticationToken;
import com.Gangof5.ecommerce.model.User;
import com.Gangof5.ecommerce.repository.TokenRepository;
import com.Gangof5.ecommerce.repository.UserRepository;
import com.Gangof5.ecommerce.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.bind.DatatypeConverter;
import static com.Gangof5.ecommerce.config.MessageStrings.USER_UPDATED;
import static com.Gangof5.ecommerce.config.MessageStrings.USER_CREATED;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthenticationService authenticationService;
	@Autowired
    TokenRepository tokenrepository;

	Logger logger = LoggerFactory.getLogger(UserService.class);

	public ResponseDto signUp(SignupDto signupDto) throws CustomException {

		if (Helper.notNull(userRepository.findByEmail(signupDto.getEmail()))) {
			// If the email address has been registered then throw an exception.
			throw new CustomException("User already exists");
		}
		// first encrypt the password
		String encryptedPassword = signupDto.getPassword();
		try {
			encryptedPassword = hashPassword(signupDto.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}", e.getMessage());
		}

		User user = new User(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(), encryptedPassword,
				signupDto.getAddress(), signupDto.getGender(), signupDto.getCountry(), signupDto.getBirthday(),
				Role.user);
		User createdUser;
		try {
			// save the User
			createdUser = userRepository.save(user);
			// generate token for user
			final AuthenticationToken authenticationToken = new AuthenticationToken(createdUser);
			// save token in database
			authenticationService.saveConfirmationToken(authenticationToken);
			// success in creating
			return new ResponseDto(ResponseStatus.success.toString(), USER_CREATED);
		} catch (Exception e) {
			// handle signup error
			throw new CustomException(e.getMessage());
		}
	}

	public SignInResponseDto signIn(SignInDto signInDto) throws CustomException {

		User user = userRepository.findByEmail(signInDto.getEmail());

		if (!Helper.notNull(user)) {

			throw new AuthenticationFailException("user not present");
		}
		try {
			// check if password is right
			if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
				// passowrd doesnot match
				throw new AuthenticationFailException(MessageStrings.WRONG_PASSWORD);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}", e.getMessage());
			throw new CustomException(e.getMessage());
		}

		AuthenticationToken token = authenticationService.getToken(user);

		if (!Helper.notNull(token)) {
			// token not present
			throw new CustomException("token not present");
		}

		return new SignInResponseDto("success", token.getToken());
	}

	String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return myHash;
	}

	public ResponseDto createUser(String token, UserCreateDto userCreateDto)
			throws CustomException, AuthenticationFailException {
		User creatingUser = authenticationService.getUser(token);
		if (!canCrudUser(creatingUser.getRole())) {
			// user can't create new user
			throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
		}
		String encryptedPassword = userCreateDto.getPassword();
		try {
			encryptedPassword = hashPassword(userCreateDto.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}", e.getMessage());
		}

		User user = new User(userCreateDto.getFirstName(), userCreateDto.getLastName(), userCreateDto.getEmail(),
				encryptedPassword, userCreateDto.getAddress(), userCreateDto.getGender(), userCreateDto.getCountry(),
				userCreateDto.getBirthday(), userCreateDto.getRole());
		User createdUser;
		try {
			createdUser = userRepository.save(user);
			final AuthenticationToken authenticationToken = new AuthenticationToken(createdUser);
			authenticationService.saveConfirmationToken(authenticationToken);
			return new ResponseDto(ResponseStatus.success.toString(), USER_CREATED);
		} catch (Exception e) {
			// handle user creation fail error
			throw new CustomException(e.getMessage());
		}

	}

	boolean canCrudUser(Role role) {
		if (role == Role.admin || role == Role.manager) {
			return true;
		}
		return false;
	}

	boolean canCrudUser(User userUpdating, Integer userIdBeingUpdated) {
		Role role = userUpdating.getRole();
		// admin and manager can crud any user
		if (role == Role.admin || role == Role.manager) {
			return true;
		}
		// user can update his own record, but not his role
		if (role == Role.user && userUpdating.getId() == userIdBeingUpdated) {
			return true;
		}
		return false;
	}

	public ResponseDto updateUser(String token, UserUpdateDto userUpdateDto)

			throws CustomException, AuthenticationFailException {

		String encryptedPassword = userUpdateDto.getPassword();
		try {
			encryptedPassword = hashPassword(userUpdateDto.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}", e.getMessage());
		}

		User UpdatedUser = authenticationService.getUser(token);

		UpdatedUser.setFirstName(userUpdateDto.getFirstName());
		UpdatedUser.setLastName(userUpdateDto.getLastName());
		UpdatedUser.setAddress(userUpdateDto.getAddress());
		UpdatedUser.setGender(userUpdateDto.getGender());
		UpdatedUser.setCountry(userUpdateDto.getCountry());
		UpdatedUser.setBirthday(userUpdateDto.getBirthday());
		UpdatedUser.setPassword(encryptedPassword);
		userRepository.save(UpdatedUser);
		return new ResponseDto(ResponseStatus.success.toString(), USER_UPDATED);
	}

	public List<User> GetAllUsers(String token) throws CustomException, AuthenticationFailException {
		User ManagerUser = authenticationService.getUser(token);
		if (!canCrudUser(ManagerUser.getRole())) {
			// user can't create new user
			throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
		}
		return userRepository.findAll();
	}

	public List<User> GetUsersByRole(String token, Role role) throws CustomException, AuthenticationFailException {
		User ManagerUser = authenticationService.getUser(token);
		if (!canCrudUser(ManagerUser.getRole())) {
			// user can't create new user
			throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
		}
		return userRepository.findByRole(role);
	}

	/**
	 * switch Role To Premium
	 */
	// private ResponseEntity<?> switchRoleToPremium(String token) {

	// return ResponseEntity.ok(new MessageResponse("User registered
	// successfully!"));
	// }

	// public User getCurrentUser() {
	// String email =
	// SecurityContextHolder.getContext().getAuthentication().getName();
	// return userRepository.findByEmail(email).orElseThrow(null);
	// }

	public void deleteUserById(String token, Integer id) throws CustomException, AuthenticationFailException {

		User ManagerUser = authenticationService.getUser(token);

		if (!canCrudUser(ManagerUser.getRole())) {

			throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
		}
		userRepository.deleteById(id);
	}

	public MessageResponse logout(String token) {

		if (!Helper.notNull(token)) {

			throw new AuthenticationFailException("user not present");
		}
		User LoggedUser = authenticationService.getUser(token);

		tokenrepository.deleteById(LoggedUser.getId());

		return new MessageResponse("Log out successful!");

	}

}
