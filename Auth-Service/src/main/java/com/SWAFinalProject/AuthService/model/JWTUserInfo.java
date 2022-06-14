package com.SWAFinalProject.AuthService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class JWTUserInfo {
    private UUID userId;
    private String name;
    private String userName;
    private String emailAddress;
    private List<String> roles;
}
