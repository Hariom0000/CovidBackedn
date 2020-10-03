package com.covid19.covid.service.serviceImpl;

import com.covid19.covid.DataLoader;
import com.covid19.covid.entities.CountryCovid;
import com.covid19.covid.repository.CountryCovidRepo;
import com.covid19.covid.service.CountryWriteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryWriteServiceImpl implements CountryWriteService{

    @Autowired
    private DataLoader dataLoader;

    @Autowired
    private CountryCovidRepo countryCovidRepo; 

    @Override
    public CountryCovid getCountryCovidAndSaveByName(String name) {
        CountryCovid countryCovid = dataLoader.getCountryCovidByName(name);
        countryCovidRepo.saveAndFlush(countryCovid);
        return countryCovid;
    }

    @Override
    public CountryCovid getCountryCovidAndSaveByCode(String code) {
        CountryCovid countryCovid= dataLoader.getCountryCovidByCode(code);
        countryCovidRepo.saveAndFlush(countryCovid);
        return countryCovid;
    }
   
}
