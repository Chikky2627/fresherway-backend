package com.fresherway.fresherway.dto;

public class ProfileRequest {
    private Long userId;
    private String college;
    private String branch;
    private Double cgpa;
    private String skills;
    private String resumeUrl;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public Double getCgpa() {
        return cgpa;
    }
    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String getResumeUrl() {
        return resumeUrl;
    }
    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }
    
}
