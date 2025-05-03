package com.boccia.api.http.services.infrastructure;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boccia.api.repositories.CountryRepository;
import com.boccia.api.repositories.PlayerRepository;
import com.boccia.api.repositories.TeamRepository;
import com.boccia.api.http.dto.PlayerDto;
import com.boccia.api.model.Country;
import com.boccia.api.model.Player;
import com.boccia.api.model.Team;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl {

    private final PlayerRepository playerRepository;
    private final CountryRepository countryRepository;
    private final TeamRepository teamRepository;


    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player create(PlayerDto dto) {
        Country country = countryRepository.findById(dto.getCountryId())
            .orElseThrow(() -> new RuntimeException("País no encontrado"));

        Team team = teamRepository.findById(dto.getTeamId())
            .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        Player player = new Player();
        player.setName(dto.getName());
        player.setAge(dto.getAge());
        player.setGender(dto.getGender());
        player.setCountry(country);
        player.setTeam(team);

        return playerRepository.save(player);
    }
}
