package com.example.legalchecker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Tüm endpoint'ler için geçerli
                .allowedOrigins("http://localhost:3000") // İzin verilen frontend URL'si
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // İzin verilen HTTP metotları
                .allowedHeaders("*") // Tüm header'lara izin ver
                .allowCredentials(true); // Kimlik bilgilerini ilet (isteğe bağlı)
    }
}
