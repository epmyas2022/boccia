package com.boccia.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boccia.api.model.Country;
public interface CountryRepository extends JpaRepository<Country, Long> {}
