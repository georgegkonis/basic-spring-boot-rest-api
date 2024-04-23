package com.bioagg.controller;

import com.bioagg.dto.request.LoginRequest;
import com.bioagg.dto.response.LoginResponse;
import com.bioagg.utility.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            final var authToken = new UsernamePasswordAuthenticationToken(request.username(), request.password());
            final var authentication = authManager.authenticate(authToken);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            final var jwt = jwtUtil.GenerateToken(request.username());
            final var response = new LoginResponse(jwt);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + e.getMessage());
        }
    }

    @PostMapping("logout")
    public ResponseEntity<Void> logout() {
        SecurityContextHolder.clearContext();

        return ResponseEntity.noContent().build();
    }
}
