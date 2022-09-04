package com.span.challenge;

import com.span.challenge.exception.RankingFileException;
import com.span.challenge.model.Ranking;
import com.span.challenge.reader.impl.RankingFileIOImpl;
import com.span.challenge.service.RankingService;
import com.span.challenge.service.impl.RankingServiceImpl;
import com.span.challenge.utils.RankingPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

import static com.span.challenge.constants.ConstantsUtils.DEFAULT_INPUT_FILE;

@SpringBootApplication(scanBasePackages = "com.span.challenge")
@EnableAutoConfiguration
public class ChallengeApplication implements CommandLineRunner {

	@Autowired
	private RankingServiceImpl rankingService;

	@Autowired
	private RankingFileIOImpl rankingFile;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}


	@Override
	public void run(String... args) throws RankingFileException, IOException {
		String path = DEFAULT_INPUT_FILE;
		for (int i = 0; i < args.length; ++i) {
			if(i == 0)
				path = args[i];
		}
		List<String> input = rankingFile.readInputFile(path);
		List<Ranking> results = rankingService.calculateRanking(input);
		rankingFile.writeOutputFile(results);
	}
}
