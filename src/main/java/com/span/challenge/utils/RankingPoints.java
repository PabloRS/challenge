package com.span.challenge.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
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
