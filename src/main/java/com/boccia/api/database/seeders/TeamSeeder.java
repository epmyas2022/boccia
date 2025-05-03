package com.boccia.api.database.seeders;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.boccia.api.model.Country;
import com.boccia.api.model.Team;
import com.boccia.api.repositories.CountryRepository;
import com.boccia.api.repositories.TeamRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TeamSeeder implements CommandLineRunner {

    private final TeamRepository teamRepository;

    @Override
    public void run(String... args) throws Exception {

        if (teamRepository.count() == 0) {

            Team teamA = new Team();
            teamA.setName("Team A");

            Team teamB = new Team();
            teamB.setName("Team B");

            List<Team> teams = List.of(teamA, teamB);
            teamRepository.saveAll(teams);
            
            System.out.println("📌 Equipos insertados con éxito.");
        }
    }

}
