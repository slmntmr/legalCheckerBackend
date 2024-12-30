package com.example.legalchecker.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PrivacyPolicyService {

    public boolean checkPrivacyPolicy(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            String bodyText = document.body().text().toLowerCase();
            return bodyText.contains("privacy") || bodyText.contains("gizlilik");
        } catch (IOException e) {
            throw new RuntimeException("URL'e erişim sağlanamadı: " + e.getMessage());
        }
    }
}
