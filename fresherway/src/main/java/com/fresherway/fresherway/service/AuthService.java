package com.fresherway.fresherway.service;
//import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
//import java.util.UUID;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fresherway.fresherway.dto.LoginRequest;
import com.fresherway.fresherway.dto.RegisterRequest;
import com.fresherway.fresherway.entity.User;
import com.fresherway.fresherway.entity.VerificationToken;
import com.fresherway.fresherway.repository.UserRepository;
import com.fresherway.fresherway.repository.VerificationTokenRepository;
	
	@Service
	public class AuthService {
		//private final EmailService emailService;
		private final PasswordEncoder passwordEncoder;

	    private final UserRepository userRepository;
		//private final VerificationTokenRepository tokenRepository;
        private final JwtService jwtService;

		AuthService(UserRepository userRepository, VerificationTokenRepository tokenRepository, EmailService emailService, PasswordEncoder passwordEncoder, JwtService jwtService) {
			this.userRepository = userRepository;
			//this.tokenRepository = tokenRepository;
			//this.emailService = emailService;
			this.passwordEncoder = passwordEncoder;
            this.jwtService = jwtService;
            
		}

	    public Map<String, String> register(RegisterRequest request) {

	        if(userRepository.existsByEmail(request.getEmail())) {

	            Map<String, String> response = new HashMap<>();
	            response.put("message", "Email already registered");

	            return response;
	        }

	        User user = new User();
            // System.out.println("Selected Role: " + request.getRole());

	        user.setName(request.getName());
	        user.setEmail(request.getEmail());
	        user.setPassword(
                passwordEncoder.encode(
                request.getPassword()
                 )
            );
            user.setRole(request.getRole());
	        user.setVerified(false);

	        userRepository.save(user);
			


Map<String, String> response = new HashMap<>();
response.put("message", "User Registered Successfully");

return response;
	    }
public Map<String, String> login(LoginRequest request) {

    Map<String, String> response = new HashMap<>();

    User user = userRepository
            .findByEmail(request.getEmail())
            .orElse(null);

    if (user == null) {
        response.put("message", "User Not Found");
        return response;
    }

   

    if (!passwordEncoder.matches(
            request.getPassword(),
            user.getPassword())) {

        response.put("message", "Invalid Password");
        return response;
    }

    String token =
            jwtService.generateToken(
                    user.getEmail(),
                    user.getRole());

    response.put("message", "Login Successful");
    response.put("token", token);
    response.put("userId", user.getId().toString());
    response.put("role", user.getRole());

    return response;
}
    }