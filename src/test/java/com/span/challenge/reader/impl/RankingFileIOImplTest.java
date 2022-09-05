package com.span.challenge.reader.impl;

import com.span.challenge.constants.ConstantsUtils;
import com.span.challenge.exception.RankingFileException;
import com.span.challenge.model.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RankingFileIOImplTest {

    @InjectMocks
    private RankingFileIOImpl rankingFileIO;

    @DisplayName("Test reading input file")
    @Test
    public void readInputFile() {
        String pathFile = "src/test/resources/input/input.txt";
        List<String> expectedLines = null;
        List<String> actualLines = null;
        try {
            expectedLines = Files.readAllLines(Paths.get(pathFile), StandardCharsets.UTF_8);
            actualLines = rankingFileIO.readInputFile(ConstantsUtils.DEFAULT_INPUT_FILE);
        } catch (IOException ex) {
            ex.getMessage();
        }
        assertEquals(expectedLines.size(), actualLines.size());
    }

    @DisplayName("Test reading input file and throw an exception")
    @Test
    public void readInputFile_WithException() {
        String message = "";
        try {
            rankingFileIO.readInputFile("bad/pathFIle");
        } catch (RankingFileException ex) {
            message = ex.getMessage();
        }
        assertEquals("Please provide a valid input file", message);
    }

    @DisplayName("Test writing output file")
    @Test
    public void writeOutputFile() {
        String outputFile = System.getProperty("user.home")+"/output.txt";
        try {
            rankingFileIO.writeOutputFile(generateMockResults());
        } catch (IOException e) {

        }
        Path path = Paths.get(outputFile);
        assertTrue(Files.exists(path));
    }

    private List<Ranking> generateMockResults() {
        List<Ranking> results = new ArrayList<>();
        for(int i=1; i<=5; i++) {
            Ranking r = new Ranking();
            r.setRank(i);
            r.setTeam("Team no." + i);
            r.setPoints(i);
            results.add(r);
        }
        return results;
    }

}