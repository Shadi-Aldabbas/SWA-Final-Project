package com.finalproject.questionsservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.lang.annotation.Documented;
import java.util.UUID;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questions {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Indexed

    @SASI(indexMode = SASI.IndexMode.CONTAINS)
    @SASI.StandardAnalyzed
    private String title;
    @SASI(indexMode = SASI.IndexMode.CONTAINS)
    @SASI.StandardAnalyzed
    private String description;
    private Boolean published;
    private boolean is_deleted;


}
