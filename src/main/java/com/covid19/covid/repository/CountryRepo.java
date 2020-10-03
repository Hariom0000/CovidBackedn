package com.covid19.covid.repository;

import com.covid19.covid.entities.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country, String>{
    
    @Modifying
    @Query("UPDATE Country c SET c.favourite=?1 WHERE c.name=?2")
    public void updateFavourite(Boolean favourite, String countryName);
    
}
