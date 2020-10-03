package com.covid19.covid.repository;

import com.covid19.covid.entities.CountryCovid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryCovidRepo extends JpaRepository<CountryCovid,Integer>{
    
    @Query("FROM  CountryCovid cc WHERE cc.country=?1")
    CountryCovid getByName(String name); 

    @Query("FROM  CountryCovid cc WHERE cc.code=?1")
    CountryCovid getByCode(String code); 

}
