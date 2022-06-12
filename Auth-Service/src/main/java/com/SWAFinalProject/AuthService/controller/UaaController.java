package com.SWAFinalProject.AuthService.controller;

import com.SWAFinalProject.AuthService.model.LoginRequest;
import com.SWAFinalProject.AuthService.model.LoginResponse;
import com.SWAFinalProject.AuthService.model.RefreshTokenRequest;
import com.SWAFinalProject.AuthService.service.UaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/uaa")
@CrossOrigin
public class UaaController {

    private final UaaService uaaService;

    public UaaController(UaaService uaaService) {
        this.uaaService = uaaService;
    }

    @GetMapping("/test")
    public String test() {
        return "test work";
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }
}
