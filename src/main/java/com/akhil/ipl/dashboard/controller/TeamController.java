package com.akhil.ipl.dashboard.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akhil.ipl.dashboard.iservice.IMatchService;
import com.akhil.ipl.dashboard.iservice.ITeamService;
import com.akhil.ipl.dashboard.model.Match;
import com.akhil.ipl.dashboard.model.Team;

@RestController
@CrossOrigin
public class TeamController {

	@Autowired
	private ITeamService iTeamService;

	@Autowired
	private IMatchService iMatchService;

	@GetMapping("/team/{teamname}")
	private ResponseEntity<?> teamData(@PathVariable("teamname") String teamName) {
		Team team = iTeamService.getTeamData(teamName);
		return new ResponseEntity<>(team, HttpStatus.OK);
	}

	@GetMapping("/team/{teamname}/matches")
	private ResponseEntity<?> teamDataOnYear(@PathVariable("teamname") String teamName,
			@RequestParam("year") int year) {
		LocalDate startDate = LocalDate.of(year, 1, 1);
		LocalDate endDate = LocalDate.of(year + 1, 1, 1);
		List<Match> match = iMatchService.findTeamDataByYear(teamName, startDate, endDate);
		return new ResponseEntity<>(match, HttpStatus.OK);
	}

	@GetMapping("/team")
	private ResponseEntity<?> team() {
		List<Team> team = iTeamService.getTeam();
		return new ResponseEntity<>(team, HttpStatus.OK);
	}
}
