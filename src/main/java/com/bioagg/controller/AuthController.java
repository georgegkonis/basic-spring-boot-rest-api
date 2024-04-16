package com.bioagg.controller;

import com.bioagg.dto.request.LoginRequest;
import com.bioagg.dto.response.LoginResponse;
import com.bioagg.utility.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest loginRequest
    ) {
        final var authToken = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
        final var authentication = authManager.authenticate(authToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final var jwt = jwtUtil.GenerateToken(loginRequest.username());
        final var response = new LoginResponse(jwt);

        return ResponseEntity.ok(response);
    }

    @PostMapping("logout")
    public ResponseEntity<Void> logout() {
        SecurityContextHolder.clearContext();

        return ResponseEntity.noContent().build();
    }
}
