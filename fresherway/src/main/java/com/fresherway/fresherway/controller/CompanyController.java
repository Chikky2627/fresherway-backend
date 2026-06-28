package com.fresherway.fresherway.controller;
 import org.springframework.web.bind.annotation.*;
  @RestController
   @RequestMapping("/api/company") 
  public class CompanyController { 
    @GetMapping("/hello") 
  
  public String companyAccess() { 
    return "Company Access Success"; 
} 
}