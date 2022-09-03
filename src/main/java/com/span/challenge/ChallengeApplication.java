package com.span.challenge;

import com.span.challenge.exception.RankingFileException;
import com.span.challenge.reader.impl.RankingFileIOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.span.challenge.constants.ConstantsUtils.DEFAULT_INPUT_FILE;

@SpringBootApplication(scanBasePackages = "com.span.challenge")
@EnableAutoConfiguration
public class ChallengeApplication implements CommandLineRunner {

	@Autowired
	private RankingPoints rankingPoints;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}


	@Override
	public void run(String... args) throws RankingFileException {
		String path = DEFAULT_INPUT_FILE;
		for (int i = 0; i < args.length; ++i) {
			if(i == 0)
				path = args[i];
		}
		new RankingFileIOImpl().readInputFile(path);
	}
}
