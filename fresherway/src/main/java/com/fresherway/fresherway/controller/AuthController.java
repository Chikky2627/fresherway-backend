package com.fresherway.fresherway.controller;

	import java.util.Map;
	import org.springframework.web.bind.annotation.*;

import com.fresherway.fresherway.dto.LoginRequest;
import com.fresherway.fresherway.dto.RegisterRequest;
	import com.fresherway.fresherway.service.AuthService;

import jakarta.validation.Valid;

	@RestController
	@RequestMapping("/api/auth")
	public class AuthController {
        
	    private final AuthService authService;


		AuthController(AuthService authService) {
			this.authService = authService;
		}
	   

	    @PostMapping("/register")
	    public Map<String, String> register(@Valid @RequestBody RegisterRequest request) {

	        return authService.register(request);
	    }
		@GetMapping("/verify")
          public String verify(@RequestParam String token) {
          return authService.verifyAccount(token);
        }
        @PostMapping("/login")
          public Map<String,String> login(
        @RequestBody LoginRequest request){
          return authService.login(request);
         }
	}

