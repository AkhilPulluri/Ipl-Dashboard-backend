package com.akhil.ipl.dashboard.iservice;

import java.util.List;

import com.akhil.ipl.dashboard.model.Team;

public interface ITeamService {
	Team getTeamData(String teamName);

	List<Team> getTeam();
}
