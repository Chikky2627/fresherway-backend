package com.fresherway.fresherway.service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


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
		private final EmailService emailService;
		private final PasswordEncoder passwordEncoder;

	    private final UserRepository userRepository;
		private final VerificationTokenRepository tokenRepository;
        private final JwtService jwtService;

		AuthService(UserRepository userRepository, VerificationTokenRepository tokenRepository, EmailService emailService, PasswordEncoder passwordEncoder, JwtService jwtService) {
			this.userRepository = userRepository;
			this.tokenRepository = tokenRepository;
			this.emailService = emailService;
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
			VerificationToken token = new VerificationToken();

token.setToken(generateToken());
token.setUserId(user.getId());
token.setExpiryDate(LocalDateTime.now().plusHours(24));

tokenRepository.save(token);

try {
    emailService.sendVerificationEmail(
            user.getEmail(),
            token.getToken()
    );
} catch (Exception e) {
    System.out.println("Email sending failed: " + e.getMessage());
}

Map<String, String> response = new HashMap<>();
response.put("message", "User Registered Successfully");

return response;
	    }
		private String generateToken() {
    return UUID.randomUUID().toString();
} 
public String verifyAccount(String token) {

    VerificationToken verificationToken =
            tokenRepository.findByToken(token)
                    .orElse(null);

    if (verificationToken == null) {
        return "Invalid Token";
    }

    User user = userRepository
            .findById(verificationToken.getUserId())
            .orElse(null);

    if (user == null) {
        return "User Not Found";
    }

    user.setVerified(true);

    userRepository.save(user);

    return "Account Verified Successfully";
}
public Map<String,String> login(LoginRequest request){

    Map<String,String> response = new HashMap<>();

    User user = userRepository
            .findByEmail(request.getEmail())
            .orElse(null);

    if(user == null){
        response.put("message","User Not Found");
        return response;
    }

    if(Boolean.FALSE.equals(user.getVerified())){
        response.put("message","Please verify your email first");
        return response;
    }

    if(!passwordEncoder.matches(
            request.getPassword(),
            user.getPassword())){
        response.put("message","Invalid Password");
        return response;
    }

    String token =jwtService.generateToken( user.getEmail(),user.getRole());

response.put("userId", user.getId().toString());
response.put("role", user.getRole());

    return response;
}

	}


