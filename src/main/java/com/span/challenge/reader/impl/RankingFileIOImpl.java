package com.span.challenge.reader.impl;

import com.span.challenge.constants.ConstantsUtils;
import com.span.challenge.exception.RankingFileException;
import com.span.challenge.model.Ranking;
import com.span.challenge.reader.RankingFileIO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Log4j2
@Service
public class RankingFileIOImpl implements RankingFileIO {

    @Override
    public List<String> readInputFile(String path) {
        log.traceEntry("Reading file {}", path);
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            log.error("Error reading file {}", ex.getMessage());
            throw new RankingFileException("Please provide a valid input file", ex);
        }
        return log.traceExit(lines);
    }

    @Override
    public void writeOutputFile(List<Ranking> outputRanking) throws RankingFileException, IOException {
        log.traceEntry("Writing output file with results {}", outputRanking);
            String pathFile = String.format("%s%s", System.getProperty("user.home"), ConstantsUtils.OUTPUT_FILE);
            log.info("Writing file to {}", pathFile);
            FileWriter fileWriter = new FileWriter(pathFile);
            PrintWriter printWriter  = new PrintWriter(fileWriter);
            for(Ranking r: outputRanking) {
                printWriter.println(r.toString());
            }
            printWriter.close();
        log.traceExit();
    }
}
