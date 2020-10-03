package com.covid19.covid.repository;

import com.covid19.covid.entities.LatestTotal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LatestTotalRepo extends JpaRepository<LatestTotal, Integer>{
    
}
