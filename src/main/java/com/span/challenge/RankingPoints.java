package com.span.challenge;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Data
@Service
public class RankingPoints {
    private final int tiePoints;
    private final int winPoints;
    private final int lossPoints;

    public RankingPoints(@Value("${tie-points}") int tiePoints,
                         @Value("${win-points}") int winPoints,
                         @Value("${loss-points}") int lossPoints) {
        this.tiePoints = tiePoints;
        this.winPoints = winPoints;
        this.lossPoints = lossPoints;
    }

}
