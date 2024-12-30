package com.example.legalchecker.service;

import org.springframework.stereotype.Service;

@Service
public class SSLService {

    public boolean checkSsl(String url) {
        return url.startsWith("https://");
    }
}

