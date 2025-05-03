package com.boccia.api.http.services.infrastructure;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boccia.api.http.dto.MatchDto;
import com.boccia.api.http.dto.MatchResultDto;
import com.boccia.api.model.Match;
import com.boccia.api.model.MatchResult;
import com.boccia.api.model.Team;
import com.boccia.api.repositories.MatchRepository;
import com.boccia.api.repositories.MatchResultRepository;
import com.boccia.api.repositories.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final MatchResultRepository matchResultRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match createMatch(MatchDto dto) {

        Team homeTeam = teamRepository.findById(dto.getHomeTeamId())
                .orElseThrow(() -> new RuntimeException("Equipo local no encontrado"));

        Team awayTeam = teamRepository.findById(dto.getAwayTeamId())
                .orElseThrow(() -> new RuntimeException("Equipo visitante no encontrado"));

        if (homeTeam.getId().equals(awayTeam.getId())) {
            throw new IllegalArgumentException("Un equipo no puede jugar contra sí mismo");
        }

        Match match = new Match();
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);

        return matchRepository.save(match);
    }


    public List<MatchResult> getAllResults() {
        return matchResultRepository.findAll();
    }

    public MatchResult createResult(Long matchId, MatchResultDto dto) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));

        MatchResult result = new MatchResult();

        result.setMatch(match);
        result.setHomeScore(dto.getHomeScore());
        result.setAwayScore(dto.getAwayScore());

        return matchResultRepository.save(result);
    }

}
