# FresherWay – Intelligent Job Portal with Fake Job Detection

FresherWay is a full-stack job portal developed using Java Spring Boot that connects students and companies through a secure recruitment platform. The application improves the job search experience by detecting suspicious job postings before publication and automatically removing outdated job listings after two weeks, helping freshers discover genuine and active opportunities.

## 🚀 Features

### Student Module
- Student Registration & Login
- JWT-based Authentication
- Email Verification
- Student Profile Management
- Resume Upload
- Search Jobs
- Apply for Jobs
- View Applied Jobs

### Company Module
- Company Registration & Login
- Company Profile Management
- Company Dashboard
- Post New Jobs
- Manage Job Listings

### Intelligent Features
- Rule-based Fake Job Detection
- Automatic Job Expiry after 2 Weeks
- Role-Based Access Control
- Secure Password Encryption using BCrypt

---

## 🛠 Tech Stack

**Backend**
- Java
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- JWT Authentication
- REST APIs

**Frontend**
- HTML
- CSS
- JavaScript

**Database**
- MySQL

**Tools**
- Maven
- Git
- GitHub
- Postman

---

## 📂 Database Tables

- Users
- StudentProfile
- Company
- Job
- JobApplication
- VerificationToken

---

## ⭐ Key Features

### Fake Job Detection
Every job posting is validated using rule-based checks such as:
- Unrealistic salary detection
- Registration fee detection
- Suspicious keywords
- Missing job information
- Missing required skills

### Automatic Job Expiry
Jobs are automatically marked inactive after two weeks using Spring Scheduler, ensuring students only see active opportunities.

---

## 🔐 Security

- JWT Authentication
- BCrypt Password Encryption
- Role-Based Authorization
- Email Verification

---

## 📌 Future Enhancements

- AI-powered Fake Job Detection
- Resume Recommendation System
- Job Recommendation Engine
- Interview Scheduling
- Admin Analytics Dashboard

---

## 👩‍💻 Developed By

**Pathuri Chikky*
