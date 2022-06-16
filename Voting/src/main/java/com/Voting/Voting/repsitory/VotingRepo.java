package com.Voting.Voting.repsitory;

import com.Voting.Voting.entity.Voting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VotingRepo extends CassandraRepository<Voting, String > {


    @AllowFiltering
    @Query(value = "select * from voting where answer_id = ?0 and user_id = ?1 ALLOW FILTERING")
    Optional<Voting> findByAnswer_idAndUser_id(String aId, String uId);

    @AllowFiltering
    @Query(value="select COUNT(vote) as total from voting where vote =false AND answer_id= ?0 ALLOW FILTERING")
    int negativeVoting(String id);

    @AllowFiltering
    @Query(value="select COUNT(vote) as total from voting where vote =true AND answer_id = ?0 ALLOW FILTERING")
    int positiveVoting(String id);

    @Query (value="select id from voting where id =id")
    boolean findBy(String IDTest);

}
