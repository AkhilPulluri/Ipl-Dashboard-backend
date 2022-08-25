package com.akhil.ipl.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhil.ipl.dashboard.iservice.ITeamService;
import com.akhil.ipl.dashboard.model.Team;
import com.akhil.ipl.dashboard.repo.MatchRepo;
import com.akhil.ipl.dashboard.repo.TeamRepo;

@Service
public class TeamService implements ITeamService {

	@Autowired
	private TeamRepo repo;

	@Autowired
	private MatchRepo matchRepo;

	@Override
	public Team getTeamData(String teamName) {
		Team team = repo.findByTeamName(teamName);
		team.setMatches(matchRepo.findFirst4ByTeam1OrTeam2OrderByDateDesc(teamName, teamName));
		return team;
	}

	@Override
	public List<Team> getTeam() {
		return (List<Team>) repo.findAll();
	}
}
