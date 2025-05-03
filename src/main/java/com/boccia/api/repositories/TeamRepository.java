package com.boccia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boccia.api.model.Team;
public interface TeamRepository extends JpaRepository<Team, Long> {}
