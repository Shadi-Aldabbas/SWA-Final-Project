package com.SWAFinalProject.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @PrimaryKey
    private UUID userId;
    private String name;
    private String userName;
    private String emailAddress;
    private String password;
    private List<String> roles;
}
