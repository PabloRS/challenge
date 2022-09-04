package com.span.challenge.reader;

import com.span.challenge.model.Ranking;

import java.io.IOException;
import java.util.List;

public interface RankingFileIO {

    List<String> readInputFile(String path);

    void writeOutputFile(List<Ranking> outputRanking) throws IOException;
}
