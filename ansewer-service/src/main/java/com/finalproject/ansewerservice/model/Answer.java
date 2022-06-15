package com.finalproject.ansewerservice.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@Table

public class Answer {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String question_id;
    private String user_id;
    private String description;
    private Boolean is_deleted;
}
