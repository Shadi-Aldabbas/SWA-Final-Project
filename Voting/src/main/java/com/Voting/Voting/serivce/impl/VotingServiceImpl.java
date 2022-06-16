package com.Voting.Voting.serivce.impl;

import com.Voting.Voting.dto.votingResult;
import com.Voting.Voting.entity.Voting;
import com.Voting.Voting.repsitory.VotingRepo;
import com.Voting.Voting.serivce.VotingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VotingServiceImpl implements VotingService {

    @Autowired
    VotingRepo votingRepo;

    @Override
    public List<Voting> getVotings() {
        return votingRepo.findAll();
    }

    @Override
    public void add(Voting voting) {
       var findVote = votingRepo.findByAnswer_idAndUser_id(voting.getAnswer_id(), voting.getUser_id());
        if(findVote.isPresent()){
        log.info("User voted before");
        }else{
            votingRepo.save(voting);
            log.info("Been voted");
        }

    }

    @Override
    public Optional<Voting> get(String votingId) {
        checkVoting(votingId);
        return votingRepo.findById(votingId);
    }

    @Override
    public votingResult getVotingResult(String answer_id ) {
        votingResult result = new votingResult();

        result.setAnswer_id(answer_id);
        result.setNegative_vote(votingRepo.negativeVoting(answer_id));
        result.setPositive_vote(votingRepo.positiveVoting(answer_id));

        return result;
    }

    private boolean checkVoting(String votingId) throws RuntimeException {
        if (votingRepo.findById(votingId)!=null) {
            throw new RuntimeException("No such voting for id: " + votingId);
        }
        return true;
    }


    //testingg part

    public VotingServiceImpl(VotingRepo votingRepo)
    {
        // this keyword refers to current instance
        this.votingRepo = votingRepo;
    }
}
