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

    @DisplayName("Test calculate ranking and list is ordered by rank")
    @Test
    public void calculateRanking_And_ListOrderedTest() {
        String pathFile = "src/test/resources/input/input.txt";
        List<String> input = null;
        List<Ranking> output = null;
        try {
            input = Files.readAllLines(Paths.get(pathFile), StandardCharsets.UTF_8);
            output = rankingService.calculateRanking(input);
        } catch (IOException ex) {

        }

        long r = output.iterator().next().getRank();
        for (Ranking i : output) {
            assertTrue(i.getRank() <= r);
            r = i.getRank();
        }
    }

    @DisplayName("Test calculate ranking and list is ordered by points")
    @Test
    public void calculateRanking_And_ListOrdered_By_Points() {
        String pathFile = "src/test/resources/input/input.txt";
        List<String> input = null;
        List<Ranking> output = null;
        try {
            input = Files.readAllLines(Paths.get(pathFile), StandardCharsets.UTF_8);
            output = rankingService.calculateRanking(input);
        } catch (IOException ex) {

        }

        long r = output.iterator().next().getPoints();
        for (Ranking i : output) {
            assertTrue(i.getPoints() <= r);
            r = i.getPoints();
        }
    }

    @DisplayName("Test calculate ranking and list is ordered by name")
    @Test
    public void calculateRanking_And_ListOrdered_By_Name() {
        String pathFile = "src/test/resources/input/input.txt";
        List<String> input = null;
        List<Ranking> output = null;
        try {
            input = Files.readAllLines(Paths.get(pathFile), StandardCharsets.UTF_8);
            output = rankingService.calculateRanking(input);
        } catch (IOException ex) {

        }

        String r = output.iterator().next().getTeam();
        for (Ranking i : output) {
            assertTrue(i.getTeam().compareToIgnoreCase(r) >= 0);
            r = i.getTeam();
        }
    }


}