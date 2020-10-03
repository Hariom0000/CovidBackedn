package com.covid19.covid.transferObjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CountryCovidTO implements Serializable {

    /** default version id  */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String code;
    private Long latitude;
    private Long longitude;
    private String lastChange;
    private String lastUpdate;
    private String country;
    private Integer confirmed;
    private Integer recovered;
    private Integer deaths;
    private Integer critical;
    private List<CommentsTO> comments=new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public String getLastChange() {
        return lastChange;
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public List<CommentsTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentsTO> comments) {
        this.comments = comments;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }    
    
}
