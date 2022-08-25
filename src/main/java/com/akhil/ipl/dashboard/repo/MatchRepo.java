package com.akhil.ipl.dashboard.repo;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.akhil.ipl.dashboard.model.Match;

public interface MatchRepo extends JpaRepository<Match, Integer> {

	List<Match> findFirst4ByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2);

	@Query("select m from Match m where (m.team1=:teamName or m.team2=:teamName) and m.date between :startDate and :endDate order by date desc")
	List<Match> getTeamDataByYear(@Param("teamName") String teamName, @Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate);

}
