package com.SWAFinalProject.AuthService.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.UUID;


@Table("roles")
@Data

public class Role {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKey
    private UUID id;

    private String role;
}
