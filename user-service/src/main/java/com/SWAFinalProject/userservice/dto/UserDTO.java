package com.SWAFinalProject.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.util.List;
import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = false)
public class UserDTO {


    private UUID userId;
    private String name;
    private String userName;
    private String emailAddress;
    private List<String> roles;
}
