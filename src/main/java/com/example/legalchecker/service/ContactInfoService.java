package com.example.legalchecker.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ContactInfoService {

    public boolean checkContactInfo(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            String bodyText = document.body().text().toLowerCase();
            return bodyText.contains("contact") || bodyText.contains("iletişim")
                    || bodyText.contains("email") || bodyText.contains("e-posta");
        } catch (IOException e) {
            throw new RuntimeException("URL'e erişim sağlanamadı: " + e.getMessage());
        }
    }
}
