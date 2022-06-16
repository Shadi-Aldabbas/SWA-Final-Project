package com.Voting.Voting.dto;

import lombok.Data;

@Data
public class votingResult {
    private String answer_id;
    private int positive_vote;
    private int negative_vote;
}
