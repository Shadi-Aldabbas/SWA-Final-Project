package com.Voting.Voting.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@Table
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Voting {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    private String user_id;
    private String answer_id;
    private Boolean vote;



}
