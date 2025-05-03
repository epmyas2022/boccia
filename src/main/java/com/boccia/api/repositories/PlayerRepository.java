package com.boccia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boccia.api.model.Player;
public interface PlayerRepository extends JpaRepository<Player, Long> {}
