package com.finalproject.questionsservice.Repo;
import com.finalproject.questionsservice.Entity.Questions;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionsRepo extends CassandraRepository<Questions, String> {
        @AllowFiltering

        List<Questions> findByTitleContaining(String title);
        List<Questions> findByDescription(String description);



}
