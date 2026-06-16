package com.fresherway.fresherway.service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


import org.springframework.stereotype.Service;
import com.fresherway.fresherway.dto.RegisterRequest;
import com.fresherway.fresherway.entity.User;
import com.fresherway.fresherway.entity.VerificationToken;
import com.fresherway.fresherway.repository.UserRepository;
import com.fresherway.fresherway.repository.VerificationTokenRepository;
	
	@Service
	public class AuthService {
		private final EmailService emailService;

	    private final UserRepository userRepository;
		private final VerificationTokenRepository tokenRepository;

		AuthService(UserRepository userRepository, VerificationTokenRepository tokenRepository, EmailService emailService) {
			this.userRepository = userRepository;
			this.tokenRepository = tokenRepository;
			this.emailService = emailService;
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
	        user.setPassword(request.getPassword());
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
	}

