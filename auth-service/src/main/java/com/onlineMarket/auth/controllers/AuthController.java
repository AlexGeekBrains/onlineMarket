package com.onlineMarket.auth.controllers;

import com.onlineMarket.api.dto.JwtResponse;
import com.onlineMarket.auth.dto.TokenResponseDto;
import com.onlineMarket.auth.integrations.Oa2Integration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final Oa2Integration oa2Integration;
    private final JwtDecoder jwtDecoder;

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestParam String session_state, @RequestParam String code) {
        TokenResponseDto tokenResponseDto = oa2Integration.getToken(code);
        System.out.println(jwtDecoder.decode(tokenResponseDto.getAccessToken()).getClaims().get("name"));
        return ResponseEntity.ok(new JwtResponse(tokenResponseDto.getAccessToken()));
    }
}
