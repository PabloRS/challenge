package com.span.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ranking {

    private int rank;
    private String team;
    private int points;

    @Override
    public String toString() {
        String pts = points > 1 ? " pts" : " pt";
        return rank + ". " + team + ", " + points +  pts;
    }
}
