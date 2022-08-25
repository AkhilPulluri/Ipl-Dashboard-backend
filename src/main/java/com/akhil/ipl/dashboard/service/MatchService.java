package com.akhil.ipl.dashboard.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhil.ipl.dashboard.iservice.IMatchService;
import com.akhil.ipl.dashboard.model.Match;
import com.akhil.ipl.dashboard.repo.MatchRepo;

@Service
public class MatchService implements IMatchService {
	@Autowired
	private MatchRepo repo;

	@Override
	public List<Match> findTeamDataByYear(String teamName, LocalDate startDate, LocalDate endDate) {
		List<Match> matchList = repo.getTeamDataByYear(teamName, startDate, endDate);
		return matchList;
	}

}
