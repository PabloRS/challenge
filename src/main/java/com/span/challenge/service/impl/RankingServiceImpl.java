package com.span.challenge.service.impl;

import com.span.challenge.model.Ranking;
import com.span.challenge.service.RankingService;
import com.span.challenge.utils.RankingPoints;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j2
public class RankingServiceImpl implements RankingService {

    @Autowired
    private RankingPoints rankingPoints;

    private List<Ranking> rankingList = new ArrayList<>();

    private Map<String, Integer> positions = new HashMap<>();

    @Override
    public List<Ranking> calculateRanking(List<String> inputList) {
        log.traceEntry("Calculate ranking with {}", inputList);
        List<String> ranking = new LinkedList<>();
        inputList.forEach(i -> {
            String[] line = i.split("\\s*,\\s*");
            calculatePoints(line);
        });
        createRankingList();
        generateRanking();
        return log.traceExit(rankingList);
    }

    private void createRankingList() {
        Ranking team;
        for (Map.Entry<String, Integer> entry : positions.entrySet()) {
            team = new Ranking();
            team.setTeam(entry.getKey());
            team.setPoints(entry.getValue());
            rankingList.add(team);
        }
    }

    private void generateRanking() {
        rankingList.sort((Comparator.comparingInt(Ranking::getPoints).reversed()));
        for(int i=0; i<rankingList.size(); i++) {
            if(i>0 && rankingList.get(i).getPoints() == rankingList.get(i-1).getPoints()) {
                rankingList.get(i).setRank(rankingList.get(i-1).getRank());
            } else {
                rankingList.get(i).setRank(i+1);
            }
        }
        rankingList.sort((Comparator.comparingInt(Ranking::getRank).thenComparing(Ranking::getTeam)));
    }

    private void calculatePoints(String[] inputTeams) {
        Ranking team1 = new Ranking();
        Ranking team2 = new Ranking();

        int p = 0;
        p = inputTeams[0].lastIndexOf(" ");
        team1.setTeam(inputTeams[0].substring(0, p).trim());
        team1.setPoints(Integer.parseInt(inputTeams[0].substring(p).trim()));

        p = inputTeams[1].lastIndexOf(" ");
        team2.setTeam(inputTeams[1].substring(0, p).trim());
        team2.setPoints(Integer.parseInt(inputTeams[1].substring(p).trim()));

        int pos = team1.getPoints() - team2.getPoints();
        if(pos >= 1) {
            team1.setPoints(rankingPoints.getWinPoints());
            team2.setPoints(rankingPoints.getLossPoints());
        } else if(pos < 0) {
            team1.setPoints(rankingPoints.getLossPoints());
            team2.setPoints(rankingPoints.getWinPoints());
        } else {
            team1.setPoints(rankingPoints.getTiePoints());
            team2.setPoints(rankingPoints.getTiePoints());
        }

        if(positions.containsKey(team1.getTeam())) {
            positions.put(team1.getTeam(), team1.getPoints()+positions.get(team1.getTeam()));
        } else {
            positions.put(team1.getTeam(), team1.getPoints());
        }

        if(positions.containsKey(team2.getTeam())) {
            positions.put(team2.getTeam(), team2.getPoints()+positions.get(team2.getTeam()));
        } else {
            positions.put(team2.getTeam(), team2.getPoints());
        }

    }

}
