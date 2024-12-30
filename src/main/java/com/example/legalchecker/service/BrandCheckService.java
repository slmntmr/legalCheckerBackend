package com.example.legalchecker.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BrandCheckService {

    public boolean checkBrandInfo(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            String bodyText = document.body().text().toLowerCase();
            // Burada "marka" ile ilgili anahtar kelimeleri kontrol ediyoruz.
            return bodyText.contains("brand") || bodyText.contains("marka")
                    || bodyText.contains("logo");
        } catch (IOException e) {
            throw new RuntimeException("URL'e erişim sağlanamadı: " + e.getMessage());
        }
    }
}
