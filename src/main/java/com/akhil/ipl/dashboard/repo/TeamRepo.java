package com.akhil.ipl.dashboard.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhil.ipl.dashboard.model.Team;

public interface TeamRepo extends JpaRepository<Team, Integer> {

	Team findByTeamName(String teamName1);

}
