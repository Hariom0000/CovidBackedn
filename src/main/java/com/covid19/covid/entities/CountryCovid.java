package com.covid19.covid.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "Country_Covid")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryCovid {
    @Id
    @GeneratedValue
    @Column(name = "country_covid_id")
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

    @OneToMany(targetEntity=Comments.class,mappedBy = "countryCovid",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comments> comments;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
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

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    @Override
    public String toString() {
        return "CountryCovid [code=" + code + ", comments=" + comments + ", confirmed=" + confirmed + ", country="
                + country + ", critical=" + critical + ", deaths=" + deaths + ", id=" + id + ", lastChange="
                + lastChange + ", lastUpdate=" + lastUpdate + ", latitude=" + latitude + ", longitude=" + longitude
                + ", recovered=" + recovered + "]";
    }

    
    
}
