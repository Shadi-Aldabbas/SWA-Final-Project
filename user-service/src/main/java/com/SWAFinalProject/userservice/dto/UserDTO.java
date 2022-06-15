package com.SWAFinalProject.userservice.dto;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.util.List;
import java.util.UUID;

@Data
public class UserDTO {

    @PrimaryKey
    private UUID userId;
    private String name;
    private String userName;
    private String emailAddress;
    private List<String> roles;
}
