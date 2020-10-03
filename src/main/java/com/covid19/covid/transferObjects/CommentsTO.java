package com.covid19.covid.transferObjects;

public class CommentsTO {
    private Integer id;
    private String comment;
    private Integer countryCovidId;
    private String commentTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCountryCovidId() {
        return countryCovidId;
    }

    public void setCountryCovidId(Integer countryCovidId) {
        this.countryCovidId = countryCovidId;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }
    
}
