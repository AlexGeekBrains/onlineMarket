package com.onlineMarket.auth.integrations;

import com.onlineMarket.auth.dto.TokenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Oa2Integration {
    private final RestTemplate restTemplate;
    @Value("${keycloak.grant_type}")
    private String grantType;
    @Value("${keycloak.client_id}")
    private String clientId;
    @Value("${keycloak.redirect_uri}")
    private String redirectUri;

    public TokenResponseDto getToken(String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("grant_type", grantType);
        request.add("client_id", clientId);
        request.add("code", code);
        request.add("redirect_uri", redirectUri);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(request, headers);
        return restTemplate.exchange("http://localhost:8543/realms/master/protocol/openid-connect/token",
                HttpMethod.POST,
                entity,
                TokenResponseDto.class).getBody();
    }
}
