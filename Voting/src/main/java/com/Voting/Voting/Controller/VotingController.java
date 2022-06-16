package com.Voting.Voting.Controller;

import com.Voting.Voting.dto.votingResult;
import com.Voting.Voting.entity.Voting;
import com.Voting.Voting.serivce.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/voting")
public class VotingController {
    @Autowired
    VotingService votingService;

    @PostMapping
    public ResponseEntity<?> saveVote(@RequestBody Voting voting){
        var test = voting;
        votingService.add(voting);
        return ResponseEntity.ok("TEST");
    }

    @GetMapping
    public List<Voting> getAllDetails(){
        return votingService.getVotings();
    }

    @GetMapping("/{id}")
    public votingResult totalVotingByansweId(@PathVariable String id){

// add id bb
        return votingService.getVotingResult(id);
    }

}
