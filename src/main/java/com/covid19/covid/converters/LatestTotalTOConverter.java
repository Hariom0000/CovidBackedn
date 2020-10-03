package com.covid19.covid.converters;

import com.covid19.covid.entities.LatestTotal;
import com.covid19.covid.transferObjects.LatestTotalTO;

import org.springframework.stereotype.Component;

@Component
public class LatestTotalTOConverter {
    public LatestTotalTO fromLatestTotal(LatestTotal latestTotal){
        LatestTotalTO latestTotalTO = new LatestTotalTO();
        latestTotalTO.setConfirmed(latestTotal.getConfirmed());
        latestTotalTO.setCritical(latestTotal.getCritical());
        latestTotalTO.setDeaths(latestTotal.getDeaths());
        latestTotalTO.setLastChange(latestTotal.getLastChange());
        latestTotalTO.setLastUpdate(latestTotal.getLastUpdate());
        latestTotalTO.setRecovered(latestTotal.getRecovered());
        return latestTotalTO;
    }
}
