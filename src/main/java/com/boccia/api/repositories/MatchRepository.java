package com.boccia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boccia.api.model.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {}
