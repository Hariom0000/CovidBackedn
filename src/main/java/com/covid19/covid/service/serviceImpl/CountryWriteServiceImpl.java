package com.covid19.covid.service.serviceImpl;

import com.covid19.covid.DataLoader;
import com.covid19.covid.entities.CountryCovid;
import com.covid19.covid.repository.CountryCovidRepo;
import com.covid19.covid.service.CountryWriteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryWriteServiceImpl implements CountryWriteService{
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryWriteServiceImpl.class);

    @Autowired
    private DataLoader dataLoader;

    @Autowired
    private CountryCovidRepo countryCovidRepo; 

    @Override
    public CountryCovid getCountryCovidAndSaveByName(String name) {
        CountryCovid countryCovid = null;
        try{
            countryCovid = dataLoader.getCountryCovidByName(name);
            countryCovidRepo.saveAndFlush(countryCovid);
        } catch(Exception ex){
            LOGGER.error("Error while loading data from covid-19-data endpoint", ex);
        }
        return countryCovid;
    }

    @Override
    public CountryCovid getCountryCovidAndSaveByCode(String code) {
        CountryCovid countryCovid = null;
        try{
            countryCovid= dataLoader.getCountryCovidByCode(code);
            countryCovidRepo.saveAndFlush(countryCovid);
        } catch(Exception ex){
            LOGGER.error("Error while loading data from covid-19-data endpoint", ex);
        }
        return countryCovid;
    }
   
}
