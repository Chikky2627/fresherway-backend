package com.fresherway.fresherway.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {
	   @NotBlank(message = "Name is required")
	    private String name;
		 @Email(message = "Invalid Email")
	   @NotBlank(message = "Email is required")
	    private String email;
	   @NotBlank(message = "Password is required")
	    private String password;
		public String getRole() {
		return role;
	}
	   public void setRole(String role) {
		   this.role = role;
	   }
		private String role;
        public void setName(String name) {
        	this.name=name;
        }
        public String getName() {
        	return name;
        }
        public void setEmail(String email) {
        	this.email=email;
        }
        public String getEmail() {
        	return email;
        }
        public void setPassword(String password) {
        	this.password=password;
        }
        public String getPassword() {
        	return password;
        }
	   
	}

