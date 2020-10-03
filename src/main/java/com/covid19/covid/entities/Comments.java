package com.covid19.covid.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Comments")
public class Comments {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_covid_id")
    private CountryCovid countryCovid;

    private String comment;
    private String commentTime;

    public CountryCovid getCountryCovid() {
        return countryCovid;
    }

    public void setCountryCovid(CountryCovid countryCovid) {
        this.countryCovid = countryCovid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Comments [comment=" + comment + ", commentTime=" + commentTime + ", countryCovid=" + countryCovid
                + ", id=" + id + "]";
    }
    
    
}
