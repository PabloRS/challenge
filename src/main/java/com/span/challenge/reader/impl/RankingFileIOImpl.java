package com.span.challenge.reader.impl;

import com.span.challenge.exception.RankingFileException;
import com.span.challenge.reader.RankingFileIO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

@Log4j2
@Service
public class RankingFileIOImpl implements RankingFileIO {

    @Override
    public void readInputFile(String path) {
        log.traceEntry("Reading file {}", path);
        try {
            List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            Iterator it = lines.listIterator();
            while(it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (IOException ex) {
            log.error("Error reading file {}", ex.getMessage());

            throw new RankingFileException("Please provide a valid input file", ex);

        }
        log.traceExit();
    }

    @Override
    public void writeOutputFile() {

    }
}
