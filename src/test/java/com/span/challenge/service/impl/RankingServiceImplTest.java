package com.span.challenge.service.impl;

import com.span.challenge.model.Ranking;
import com.span.challenge.utils.RankingPoints;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RankingServiceImplTest {

    @Mock
    RankingPoints rankingPoints;
    @InjectMocks
    RankingServiceImpl rankingService;

    @DisplayName("Test calculate ranking")
    @Test
    public void calculateRankingTest() {
        String pathFile = "src/test/resources/input/input.txt";
        List<String> input = null;
        List<Ranking> output = null;
        try {
            input = Files.readAllLines(Paths.get(pathFile), StandardCharsets.UTF_8);
            output = rankingService.calculateRanking(input);
        } catch (IOException ex) {

        }
        assertEquals(input.size(), output.size());
    }

}