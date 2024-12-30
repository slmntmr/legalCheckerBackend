package com.example.legalchecker.service;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

@Service
public class CookiePolicyService {

    public boolean checkCookiePolicy(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            String bodyText = document.body().text().toLowerCase();
            return bodyText.contains("cookie") || bodyText.contains("çerez");
        } catch (IOException e) {
            throw new RuntimeException("URL'e erişim sağlanamadı: " + e.getMessage());
        }
    }
}
