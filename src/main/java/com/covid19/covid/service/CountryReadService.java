package com.covid19.covid.service;

import java.util.List;

import com.covid19.covid.transferObjects.CommentsTO;
import com.covid19.covid.transferObjects.CountryCovidTO;
import com.covid19.covid.transferObjects.CountryTO;
import com.covid19.covid.transferObjects.LatestTotalTO;

public interface CountryReadService {
    List<CountryTO> getAlCountries();
    CountryCovidTO getCountryCovidByName(String name);
    CountryCovidTO getCountryCovidByCode(String code);
    LatestTotalTO getLatestTotal();
    void updateFavourite(String countryName, Boolean favourite);
    void addComments(CommentsTO commentsTO);
}