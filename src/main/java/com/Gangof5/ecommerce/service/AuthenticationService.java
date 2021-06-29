package com.Gangof5.ecommerce.service;


import com.Gangof5.ecommerce.config.MessageStrings;
import com.Gangof5.ecommerce.exceptions.AuthenticationFailException;
import com.Gangof5.ecommerce.model.AuthenticationToken;
import com.Gangof5.ecommerce.model.User;
import com.Gangof5.ecommerce.repository.TokenRepository;
import com.Gangof5.ecommerce.repository.UserRepository;
import com.Gangof5.ecommerce.utils.Helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    TokenRepository repository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenRepository tokenrepository;
    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        repository.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user) {
        return repository.findTokenByUser(user);
    }

    public User getUser(String token) {
        AuthenticationToken authenticationToken = repository.findTokenByToken(token);
        if (Helper.notNull(authenticationToken)) {
            if (Helper.notNull(authenticationToken.getUser())) {
                return authenticationToken.getUser();
            }
        }
        return null;
    }

    public void authenticate(String token) throws AuthenticationFailException {
        if (!Helper.notNull(token)) {
            throw new AuthenticationFailException(MessageStrings.AUTH_TOEKN_NOT_PRESENT);
        }
        if (!Helper.notNull(getUser(token))) {
            throw new AuthenticationFailException(MessageStrings.AUTH_TOEKN_NOT_VALID);
        }
    }
   // @Transactional
    public int deleteByUserId(Integer userId) {
    	return  tokenrepository.deleteByUser(userRepository.findById(userId));
	   
	  }
}
