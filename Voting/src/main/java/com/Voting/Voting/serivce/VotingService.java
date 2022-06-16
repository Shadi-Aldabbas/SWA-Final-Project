package com.Voting.Voting.serivce;

import com.Voting.Voting.dto.votingResult;
import com.Voting.Voting.entity.Voting;

import java.util.List;
import java.util.Optional;

public interface VotingService {
//    Voting saveTest(Voting voting);


    List<Voting> getVotings();

    void add(Voting voting);

    Optional<Voting> get(String votingId);

    votingResult getVotingResult(String answer_id);

}
