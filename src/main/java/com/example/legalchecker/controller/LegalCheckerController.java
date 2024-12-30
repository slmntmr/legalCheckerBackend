package com.example.legalchecker.controller;

import com.example.legalchecker.dto.LegalCheckResultDTO;
import com.example.legalchecker.service.LegalCheckerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")



public class LegalCheckerController {

    private final LegalCheckerService legalCheckerService;

    // Manuel constructor
    public LegalCheckerController(LegalCheckerService legalCheckerService) {
        this.legalCheckerService = legalCheckerService;
    }

    @PostMapping("/check-url")
    public ResponseEntity<LegalCheckResultDTO> checkUrl(@RequestBody String url) {
        LegalCheckResultDTO result = legalCheckerService.checkUrl(url);
        return ResponseEntity.ok(result);
    }
}
