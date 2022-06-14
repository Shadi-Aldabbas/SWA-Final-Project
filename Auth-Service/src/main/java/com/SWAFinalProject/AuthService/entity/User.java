package com.SWAFinalProject.AuthService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.*;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Table("users")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements Serializable {

    @PrimaryKey
    private UUID userId;
    private String name;
    private String userName;
    private String emailAddress;
    private String password;
    private List<String> roles;
}
