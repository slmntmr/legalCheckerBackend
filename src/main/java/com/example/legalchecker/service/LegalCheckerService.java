package com.example.legalchecker.service;

import com.example.legalchecker.dto.LegalCheckResultDTO;
import org.springframework.stereotype.Service;

@Service
public class LegalCheckerService {

    private final CookiePolicyService cookiePolicyService;
    private final PrivacyPolicyService privacyPolicyService;
    private final TermsOfService termsOfService;
    private final SSLService sslService;
    private final ContactInfoService contactInfoService;
    private final CopyrightService copyrightService;
    private final BrandCheckService brandCheckService;
    private final GdprKvkkService gdprKvkkService;

    // Constructor
    public LegalCheckerService(
            CookiePolicyService cookiePolicyService,
            PrivacyPolicyService privacyPolicyService,
            TermsOfService termsOfService,
            SSLService sslService,
            ContactInfoService contactInfoService,
            CopyrightService copyrightService,
            BrandCheckService brandCheckService,
            GdprKvkkService gdprKvkkService
    ) {
        this.cookiePolicyService = cookiePolicyService;
        this.privacyPolicyService = privacyPolicyService;
        this.termsOfService = termsOfService;
        this.sslService = sslService;
        this.contactInfoService = contactInfoService;
        this.copyrightService = copyrightService;
        this.brandCheckService = brandCheckService;
        this.gdprKvkkService = gdprKvkkService;
    }

    public LegalCheckResultDTO checkUrl(String url) {
        boolean hasCookiePolicy = cookiePolicyService.checkCookiePolicy(url);
        boolean hasPrivacyPolicy = privacyPolicyService.checkPrivacyPolicy(url);
        boolean hasTerms = termsOfService.checkTermsOfService(url);
        boolean isSslValid = sslService.checkSsl(url);
        boolean hasContactInfo = contactInfoService.checkContactInfo(url);
        boolean hasCopyright = copyrightService.checkCopyrightInfo(url);
        boolean hasBrandInfo = brandCheckService.checkBrandInfo(url);
        boolean hasGdprKvkkCompliance = gdprKvkkService.checkGdprKvkkCompliance(url);

        return new LegalCheckResultDTO(
                url,
                hasCookiePolicy,
                hasPrivacyPolicy,
                hasTerms,
                isSslValid,
                hasContactInfo,
                hasCopyright,
                hasBrandInfo,
                hasGdprKvkkCompliance
        );
    }
}
