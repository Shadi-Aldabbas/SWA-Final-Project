package com.SWAFinalProject.AuthService.service.impl;

import com.SWAFinalProject.AuthService.entity.User;
import com.SWAFinalProject.AuthService.model.LoginRequest;
import com.SWAFinalProject.AuthService.model.LoginResponse;
import com.SWAFinalProject.AuthService.model.RefreshTokenRequest;
import com.SWAFinalProject.AuthService.repository.UserRepo;
import com.SWAFinalProject.AuthService.security.JwtHelper;
import com.SWAFinalProject.AuthService.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {

    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;

    private final UserRepo userRepo;


    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail(),userRepo.findByEmailAddress(loginRequest.getEmail()));
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }


    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()), new User());
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginResponse();
    }

//    @Override
//    public User findByEmailAddress(String emailAddress) {
//        return userRepo.findByEmailAddress(emailAddress);
//    }
}
