package com.SWAFinalProject.AuthService.service;


import com.SWAFinalProject.AuthService.entity.User;
import com.SWAFinalProject.AuthService.model.LoginRequest;
import com.SWAFinalProject.AuthService.model.LoginResponse;
import com.SWAFinalProject.AuthService.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

//    User findByEmailAddress(String emailAddress);
}
