package com.cassandra.SWAFinalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @PrimaryKey
    private String userId;
    private String name;
    private String userName;
    private String emailAddress;
    private String password;
    private String role;
}
