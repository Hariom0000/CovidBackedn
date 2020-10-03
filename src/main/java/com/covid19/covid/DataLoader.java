package com.covid19.covid;

import java.util.Arrays;

import javax.transaction.Transactional;
import com.covid19.covid.entities.Country;
import com.covid19.covid.entities.CountryCovid;
import com.covid19.covid.entities.LatestTotal;
import com.covid19.covid.repository.CountryCovidRepo;
import com.covid19.covid.repository.CountryRepo;
import com.covid19.covid.repository.LatestTotalRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataLoader implements ApplicationRunner {
    private static final String URL= "https://covid-19-data.p.rapidapi.com/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private CountryCovidRepo countryCovidRepo;

    @Autowired
    private LatestTotalRepo latestTotalRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        cleanUp();
        saveEntityData();
        getLatestTotal();
    }

    @Transactional
    private void saveEntityData(){
        HttpEntity<String> httpEntity = createHttpEntity();
        Country[] countries = getListOfCountry(httpEntity);
        for(Country country: countries){
            country.setFavourite(Boolean.FALSE);
            countryRepo.save(country);
        }
    }

    private void cleanUp(){
        countryCovidRepo.deleteAllInBatch();
        countryRepo.deleteAllInBatch();
    }

    public CountryCovid getCountryCovidByName(String name){
        String uri = URL+"country?name="+name;
        return restTemplate.exchange(uri,HttpMethod.GET,createHttpEntity(), CountryCovid[].class).getBody()[0];
    }

    public CountryCovid getCountryCovidByCode(String code){
        String uri = URL+"country/code?code="+code;
        return restTemplate.exchange(uri,HttpMethod.GET,createHttpEntity(), CountryCovid[].class).getBody()[0];
    }

    public void getLatestTotal(){
        String uri = URL+"totals";
        LatestTotal latestTotal=restTemplate.exchange(uri,HttpMethod.GET,createHttpEntity(), LatestTotal[].class).getBody()[0];
        latestTotalRepo.save(latestTotal); 
    }

    private Country[] getListOfCountry(HttpEntity<String> httpEntity){
        String uri = URL+"help/countries";
        return restTemplate.exchange(uri,HttpMethod.GET,httpEntity, Country[].class).getBody();
    }

    private HttpEntity<String> createHttpEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("x-rapidapi-host", "covid-19-data.p.rapidapi.com");
        headers.set("x-rapidapi-key", "o3BCTeOQyPmshTspkvzcH26oVQwLp1rQA62jsn7Ddo1lKxOG36");
        headers.set("useQueryString", "true");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
    return entity;
    }

    
}
