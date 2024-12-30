package com.example.legalchecker.service;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CopyrightService {

    public boolean checkCopyrightInfo(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            String bodyText = document.body().text().toLowerCase();
            return bodyText.contains("copyright") || bodyText.contains("telif")
                    || bodyText.contains("disclaimer") || bodyText.contains("yasal");
        } catch (IOException e) {
            throw new RuntimeException("URL'e erişim sağlanamadı: " + e.getMessage());
        }
    }
}
