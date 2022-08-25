package com.akhil.ipl.dashboard.data;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.akhil.ipl.dashboard.model.Match;




public class MatchDataProcessor implements ItemProcessor<MatchData, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

    @Override
    public Match process(final MatchData MatchData) throws Exception {
        Match match = new Match();
        match.setId(Long.parseLong(MatchData.getId()));
        match.setCity(MatchData.getCity());

        match.setDate(LocalDate.parse(MatchData.getDate()));

        match.setPlayerOfMatch(MatchData.getPlayer_of_match());
        match.setVenue(MatchData.getVenue());

        // Set Team 1 and Team 2 depending on the innings order
        String firstInningsTeam, secondInningsTeam;

        if ("bat".equals(MatchData.getToss_decision())) {
            firstInningsTeam = MatchData.getToss_winner();
            secondInningsTeam = MatchData.getToss_winner().equals(MatchData.getTeam1()) 
                ? MatchData.getTeam2() : MatchData.getTeam1();

        } else {
            secondInningsTeam = MatchData.getToss_winner();
            firstInningsTeam = MatchData.getToss_winner().equals(MatchData.getTeam1()) 
                ? MatchData.getTeam2() : MatchData.getTeam1();
        }
        match.setTeam1(firstInningsTeam);
        match.setTeam2(secondInningsTeam);

        match.setTossWinner(MatchData.getToss_winner());
        match.setTossDecision(MatchData.getToss_decision());
        match.setMatchWinner(MatchData.getWinner());
        match.setResult(MatchData.getResult());
        match.setResultMargin(MatchData.getResult_margin());
        match.setUmpire1(MatchData.getUmpire1());
        match.setUmpire2(MatchData.getUmpire2());

        return match;
    }

}