package com.boccia.api.http.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boccia.api.http.dto.MatchDto;
import com.boccia.api.http.dto.MatchResultDto;
import com.boccia.api.http.services.infrastructure.MatchServiceImpl;
import com.boccia.api.model.Match;
import com.boccia.api.model.MatchResult;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchServiceImpl matchService;

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        List<Match> response = matchService.getAllMatches();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody @Valid MatchDto dto) {
        Match response = matchService.createMatch(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/results/{matchId}")
    public ResponseEntity<MatchResult> createResult(
            @PathVariable Long matchId,
            @RequestBody @Valid MatchResultDto dto) {

        MatchResult response = matchService.createResult(matchId, dto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/results")
    public ResponseEntity<List<MatchResult>> getAllResults() {
        List<MatchResult> response = matchService.getAllResults();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
