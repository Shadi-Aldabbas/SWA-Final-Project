package com.SWAFinalProject.AuthService.Service;

import com.SWAFinalProject.AuthService.model.LoginRequest;
import com.SWAFinalProject.AuthService.repository.UserRepo;
import com.SWAFinalProject.AuthService.security.JwtHelper;
import com.SWAFinalProject.AuthService.service.impl.UaaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

//@ExtendWith(MockitoExtension.class)

public class UaaServiceTest {

//    @Mock private UserRepo userRepo;
//    @Mock private AuthenticationManager authenticationManager;
//    @Mock private JwtHelper jwtHelper;
//
//    private UaaServiceImpl uaaService;
//
//    @BeforeEach void setUp() {
//        this.uaaService
//                = new UaaServiceImpl(authenticationManager, jwtHelper, userRepo);
//    }
//
//    @Test void login(){
//        uaaService.login(new LoginRequest("admin@admin.com", "1"));
////        verify(userRepo).(new LoginRequest("admin@admin.com", "1"));
//    }
}
