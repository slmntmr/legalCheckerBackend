package com.example.legalchecker.dto;

public class LegalCheckResultDTO {
    private String url;
    private boolean cookiePolicy;
    private boolean privacyPolicy;
    private boolean termsOfService;
    private boolean ssl;
    private boolean contactInfo;
    private boolean copyright;
    private boolean brandInfo;
    private boolean gdprKvkkCompliance;

    // Parametreli Constructor
    public LegalCheckResultDTO(String url, boolean cookiePolicy, boolean privacyPolicy, boolean termsOfService,
                               boolean ssl, boolean contactInfo, boolean copyright,
                               boolean brandInfo, boolean gdprKvkkCompliance) {
        this.url = url;
        this.cookiePolicy = cookiePolicy;
        this.privacyPolicy = privacyPolicy;
        this.termsOfService = termsOfService;
        this.ssl = ssl;
        this.contactInfo = contactInfo;
        this.copyright = copyright;
        this.brandInfo = brandInfo;
        this.gdprKvkkCompliance = gdprKvkkCompliance;
    }

    // Getter ve Setter'lar
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isCookiePolicy() {
        return cookiePolicy;
    }

    public void setCookiePolicy(boolean cookiePolicy) {
        this.cookiePolicy = cookiePolicy;
    }

    public boolean isPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(boolean privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

    public boolean isTermsOfService() {
        return termsOfService;
    }

    public void setTermsOfService(boolean termsOfService) {
        this.termsOfService = termsOfService;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    public boolean isContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(boolean contactInfo) {
        this.contactInfo = contactInfo;
    }

    public boolean isCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public boolean isBrandInfo() {
        return brandInfo;
    }

    public void setBrandInfo(boolean brandInfo) {
        this.brandInfo = brandInfo;
    }

    public boolean isGdprKvkkCompliance() {
        return gdprKvkkCompliance;
    }

    public void setGdprKvkkCompliance(boolean gdprKvkkCompliance) {
        this.gdprKvkkCompliance = gdprKvkkCompliance;
    }
}
