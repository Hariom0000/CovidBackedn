package com.covid19.covid.converters;


import com.covid19.covid.entities.Country;
import com.covid19.covid.transferObjects.CountryTO;

import org.springframework.stereotype.Component;

@Component
public class CountryTOConverter {
    
    public CountryTO fromCountry(Country country){
        CountryTO countryTO  = new CountryTO();
        countryTO.setName(country.getName());
        countryTO.setAlpha2code(country.getAlpha2code());
        countryTO.setAlpha3code(country.getAlpha3code());
        countryTO.setLatitude(country.getLatitude());
        countryTO.setLongitude(country.getLongitude());
        countryTO.setFavourite(country.getFavourite());
    return countryTO;
    }

    public Country fromCountryTO(CountryTO countryTO){
        Country country  = new Country();
        country.setName(countryTO.getName());
        country.setAlpha2code(countryTO.getAlpha2code());
        country.setAlpha3code(countryTO.getAlpha3code());
        country.setLatitude(countryTO.getLatitude());
        country.setLongitude(countryTO.getLongitude());
        country.setFavourite(countryTO.getFavourite());
    return country;
    }
}
