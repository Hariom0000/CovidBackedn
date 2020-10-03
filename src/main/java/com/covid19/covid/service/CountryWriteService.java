package com.covid19.covid.service;

import com.covid19.covid.entities.CountryCovid;

public interface CountryWriteService {
    
    public CountryCovid getCountryCovidAndSaveByName(String name);

    public CountryCovid getCountryCovidAndSaveByCode(String code);
}
