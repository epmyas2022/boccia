package com.boccia.api.database.seeders;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.boccia.api.model.Country;
import com.boccia.api.repositories.CountryRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CountrySeeder implements CommandLineRunner {

    private final CountryRepository countryRepository;

    @Override
    public void run(String... args) {
        if (countryRepository.count() == 0) {

            Country country = new Country();

            country.setName("Argentina");
            country.setCode("ARG");
            country.setActive(true);

            List<Country> countries = List.of(country);

            countryRepository.saveAll(countries);
            System.out.println("📌 Países insertados con éxito.");
        }
    }
}