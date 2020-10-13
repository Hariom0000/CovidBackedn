package com.covid19.covid.service.serviceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.covid19.covid.converters.CommentsTOConverter;
import com.covid19.covid.converters.CountryCovidTOConverter;
import com.covid19.covid.converters.CountryTOConverter;
import com.covid19.covid.converters.LatestTotalTOConverter;
import com.covid19.covid.entities.CountryCovid;
import com.covid19.covid.entities.LatestTotal;
import com.covid19.covid.repository.CommentsRepo;
import com.covid19.covid.repository.CountryCovidRepo;
import com.covid19.covid.repository.CountryRepo;
import com.covid19.covid.repository.LatestTotalRepo;
import com.covid19.covid.service.CountryReadService;
import com.covid19.covid.service.CountryWriteService;
import com.covid19.covid.transferObjects.CommentsTO;
import com.covid19.covid.transferObjects.CountryCovidTO;
import com.covid19.covid.transferObjects.CountryTO;
import com.covid19.covid.transferObjects.LatestTotalTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryReadServiceImpl implements CountryReadService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryReadServiceImpl.class);
    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private CountryCovidRepo countryCovidRepo;

    @Autowired
    private CountryTOConverter countryTOConverter;

    @Autowired
    private CountryCovidTOConverter countryCovidTOConverter;

    @Autowired
    private CountryWriteService countryWriteService;

    @Autowired
    private LatestTotalRepo latestTotalRepo;

    @Autowired
    private LatestTotalTOConverter latestTotalTOConverter;

    @Autowired
    private CommentsTOConverter commentsTOConverter;
    
    @Autowired
    private CommentsRepo commentsRepo;

    @Override
    public List<CountryTO> getAlCountries() {
        return countryRepo.findAll().stream().map(country -> countryTOConverter.fromCountry(country))
                .sorted(Comparator.comparing(CountryTO::getFavourite, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    @Override
    public CountryCovidTO getCountryCovidByName(String name) {
        CountryCovidTO countryCovidTO = null;
        CountryCovid countryCovid = countryCovidRepo.getByName(name);
        if (countryCovid == null) {
            countryCovid = countryWriteService.getCountryCovidAndSaveByName(name);
        }
        if(countryCovid == null){
            LOGGER.info("No country found with name"+ name);
        }else{
            countryCovidTO = countryCovidTOConverter.formCountryCovid(countryCovid);
        }
        return countryCovidTO;
    }

    @Override
    public CountryCovidTO getCountryCovidByCode(String code) {
        CountryCovidTO countryCovidTO = null;
        CountryCovid countryCovid = countryCovidRepo.getByCode(code);
        if (countryCovid == null) {
            countryCovid = countryWriteService.getCountryCovidAndSaveByCode(code);
        }
        if(countryCovid == null){
            LOGGER.info("No country found with name"+ code);
        }else{
            countryCovidTO = countryCovidTOConverter.formCountryCovid(countryCovid);
        }
        return countryCovidTO;
    }

    public LatestTotalTO getLatestTotal() {
        List<LatestTotal> listOfLatestTotal = latestTotalRepo.findAll();
        LatestTotalTO latestTotalTO = null;
        if(listOfLatestTotal == null || listOfLatestTotal.isEmpty()){
            LOGGER.info("Country detail not present in the DB");
        }else{
            latestTotalTO = latestTotalTOConverter.fromLatestTotal(listOfLatestTotal.get(0));
        }
        return latestTotalTO;
    }

    @Override
    public void updateFavourite(String countryName, Boolean favourite) {
        countryRepo.updateFavourite(favourite, countryName);
    }

    @Override
    public void addComments(CommentsTO commentsTO) {
        commentsRepo.save(commentsTOConverter.fromCommentsTO(commentsTO));
    }
    
}
