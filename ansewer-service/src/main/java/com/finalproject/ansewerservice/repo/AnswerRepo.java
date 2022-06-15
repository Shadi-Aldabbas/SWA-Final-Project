package com.finalproject.ansewerservice.repo;

import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.finalproject.ansewerservice.model.Answer;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnswerRepo extends CassandraRepository<Answer, String> {
    @Query("SELECT * FROM Answer WHERE question_id = ?0 ALLOW FILTERING")
    List<Answer> findAllByQuestion(String id);

}
