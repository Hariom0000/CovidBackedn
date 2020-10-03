package com.covid19.covid.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.covid19.covid.entities.Comments;
import com.covid19.covid.entities.CountryCovid;
import com.covid19.covid.transferObjects.CommentsTO;
import com.covid19.covid.transferObjects.CountryCovidTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryCovidTOConverter {

    @Autowired
    private CommentsTOConverter commentsTOConverter;

    public CountryCovidTO formCountryCovid(CountryCovid countryCovid){
        CountryCovidTO countryCovidTO = new CountryCovidTO(); 
        
        List<CommentsTO> commentsTOs = new ArrayList<>();
        if(countryCovid.getComments()!= null){
            commentsTOs.addAll(countryCovid.getComments().stream()
            .map(comment-> commentsTOConverter.fromComments(comment))
            .collect(Collectors.toList()));
        }
        

        countryCovidTO.setCode(countryCovid.getCode());
        countryCovidTO.setCritical(countryCovid.getCritical());
        countryCovidTO.getComments().addAll(commentsTOs);
        countryCovidTO.setConfirmed(countryCovid.getConfirmed());
        countryCovidTO.setCountry(countryCovid.getCountry());
        countryCovidTO.setDeaths(countryCovid.getDeaths());
        countryCovidTO.setId(countryCovid.getId());
        countryCovidTO.setLastChange(countryCovid.getLastChange());
        countryCovidTO.setLastUpdate(countryCovid.getLastUpdate());
        countryCovidTO.setLatitude(countryCovid.getLatitude());
        countryCovidTO.setLongitude(countryCovid.getLongitude());
        countryCovidTO.setRecovered(countryCovid.getRecovered());
        return countryCovidTO;
    }

    public CountryCovid formCountryCovidTO(CountryCovidTO countryCovidTO){
        CountryCovid countryCovid = new CountryCovid(); 
        List<Comments> comments = countryCovidTO.getComments()
        .stream()
        .map(commenstTO-> commentsTOConverter.fromCommentsTO(commenstTO))
        .collect(Collectors.toList());

        countryCovid.setCode(countryCovidTO.getCode());
        countryCovid.getComments().addAll(comments);
        countryCovid.setConfirmed(countryCovidTO.getConfirmed());
        countryCovid.setCountry(countryCovidTO.getCountry());
        countryCovid.setDeaths(countryCovidTO.getDeaths());
        countryCovid.setId(countryCovidTO.getId());
        countryCovid.setLastChange(countryCovidTO.getLastChange());
        countryCovid.setLastUpdate(countryCovidTO.getLastUpdate());
        countryCovid.setLatitude(countryCovidTO.getLatitude());
        countryCovid.setLongitude(countryCovidTO.getLongitude());
        countryCovid.setRecovered(countryCovidTO.getRecovered());
        countryCovid.setCritical(countryCovidTO.getCritical());
        return countryCovid;
    }
}
