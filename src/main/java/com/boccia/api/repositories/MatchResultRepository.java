package com.boccia.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.boccia.api.model.MatchResult;

public interface MatchResultRepository extends  JpaRepository<MatchResult, Long> {
    MatchResult findByMatchId(Long matchId);
}
