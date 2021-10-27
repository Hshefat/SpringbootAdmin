package com.sts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sts.models.Client;
import com.sts.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
