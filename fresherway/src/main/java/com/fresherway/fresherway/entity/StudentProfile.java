package com.fresherway.fresherway.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String college;

    private String branch;

    private Double cgpa;
    private String resumeFileName;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getCollege() {
        return college;
    }

    public String getBranch() {
        return branch;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public String getSkills() {
        return skills;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    private String skills;

    private String resumeUrl;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getResumeFileName() {
        return resumeFileName;
    }

    public void setResumeFileName(String resumeFileName) {
        this.resumeFileName = resumeFileName;
    }

}
