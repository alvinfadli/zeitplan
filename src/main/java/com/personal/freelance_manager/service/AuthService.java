package com.personal.freelance_manager.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.personal.freelance_manager.entity.User;
import com.personal.freelance_manager.model.LoginUserRequest;
import com.personal.freelance_manager.model.TokenResponse;
import com.personal.freelance_manager.repository.UserRepository;
import com.personal.freelance_manager.security.BCrypt;

import jakarta.transaction.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ValidationService validationService;

    @Transactional
    public TokenResponse login(LoginUserRequest request){
        validationService.validate(request);

        User user = userRepository.findById(request.getUsername()).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password is wrong"));

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next30Days());
            userRepository.save(user);

            return TokenResponse.builder().token(user.getToken()).expiredAt(user.getTokenExpiredAt()).build();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password is wrong");
        }
    }

    private Long next30Days(){
        return System.currentTimeMillis() + (1000 * 16 * 24 * 30);
    }
}
