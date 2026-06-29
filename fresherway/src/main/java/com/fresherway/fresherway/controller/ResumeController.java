package com.fresherway.fresherway.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    @PostMapping("/upload")
    public String uploadResume(
            @RequestParam("file") MultipartFile file)
            throws IOException {

        String uploadDir = "uploads/";

        Files.createDirectories(Paths.get(uploadDir));

        String fileName = file.getOriginalFilename();

        Path filePath = Paths.get(uploadDir, fileName);

        Files.write(filePath, file.getBytes());

        return "Resume Uploaded Successfully";
    }
}