package com.fresherway.fresherway.service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fresherway.fresherway.dto.RegisterRequest;
import com.fresherway.fresherway.entity.User;
import com.fresherway.fresherway.repository.UserRepository;

	@Service
	public class AuthService {

	    @Autowired
	    private UserRepository userRepository;

	    public Map<String, String> register(RegisterRequest request) {

	        if(userRepository.existsByEmail(request.getEmail())) {

	            Map<String, String> response = new HashMap<>();
	            response.put("message", "Email already registered");

	            return response;
	        }

	        User user = new User();

	        user.setName(request.getName());
	        user.setEmail(request.getEmail());
	        user.setPassword(request.getPassword());
	        user.setVerified(false);

	        userRepository.save(user);

	        Map<String, String> response = new HashMap<>();
	        response.put("message", "User Registered Successfully");

	        return response;
	    }
	}

