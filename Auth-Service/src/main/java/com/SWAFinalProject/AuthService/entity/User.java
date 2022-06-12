package com.SWAFinalProject.AuthService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.*;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table("users")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements Serializable {

    @PrimaryKey
    private UUID id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;

    private String roles;
}
