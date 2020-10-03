package com.covid19.covid.controllers;

import java.util.List;
import java.util.Map;

import com.covid19.covid.service.CountryReadService;
import com.covid19.covid.transferObjects.CommentsTO;
import com.covid19.covid.transferObjects.CountryCovidTO;
import com.covid19.covid.transferObjects.CountryTO;
import com.covid19.covid.transferObjects.LatestTotalTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CountryController {
    @Autowired
    private CountryReadService countryReadService;

    @GetMapping(path = "/totals")
    public LatestTotalTO getLatestTotal(){
        return countryReadService.getLatestTotal();
    }

    @GetMapping(path = "/countries")
    public List<CountryTO> getCountryList(){
        return countryReadService.getAlCountries();
    }

    @GetMapping(path = "/countrybyname")
    public CountryCovidTO getCountryByName(@RequestParam(name = "country", required = true) String country){
        return countryReadService.getCountryCovidByName(country);
    }

    @GetMapping(path = "/countrybycode")
    public CountryCovidTO getCountryBycode(@RequestParam(name = "code", required = true) String code){
        return countryReadService.getCountryCovidByCode(code);
    }

    @PostMapping(path = "/updatefavourite")
    public void updateFavourite(@RequestBody Map<String, String> params){
        String name = params.get("name");
        Boolean favourite = Boolean.valueOf(params.get("favourite"));
        countryReadService.updateFavourite(name, favourite);
    }

    @PostMapping(path = "/addcomment")
    public void addComment(@RequestBody CommentsTO commentsTO){
        countryReadService.addComments(commentsTO);
    }
}
