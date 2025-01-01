package com.example.legalchecker.controller;

import com.example.legalchecker.dto.LegalCheckResultDTO;
import com.example.legalchecker.dto.UrlRequestDTO;
import com.example.legalchecker.service.LegalCheckerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LegalCheckerController {

    private final LegalCheckerService legalCheckerService;

    // Constructor injection
    public LegalCheckerController(LegalCheckerService legalCheckerService) {
        this.legalCheckerService = legalCheckerService;
    }

    @PostMapping("/check-url")
    public ResponseEntity<?> checkUrl(@RequestBody UrlRequestDTO urlRequest) {
        String url = urlRequest.getUrl().trim();
        System.out.println("Trimmed URL: " + url);

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            return ResponseEntity.badRequest().body("Invalid URL format. Please include http:// or https://.");
        }

        try {
            LegalCheckResultDTO result = legalCheckerService.checkUrl(url);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An unexpected error occurred: " + e.getMessage());
        }
    }
}
