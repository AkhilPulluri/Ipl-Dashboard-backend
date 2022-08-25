package com.akhil.ipl.dashboard.iservice;

import java.time.LocalDate;
import java.util.List;

import com.akhil.ipl.dashboard.model.Match;

public interface IMatchService {
	List<Match> findTeamDataByYear(String teamName, LocalDate startDate, LocalDate endDate);

}
