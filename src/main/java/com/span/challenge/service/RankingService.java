package com.span.challenge.service;

import com.span.challenge.model.Ranking;

import java.util.List;

public interface RankingService {

    List<Ranking> calculateRanking(List<String> inputList);
}
