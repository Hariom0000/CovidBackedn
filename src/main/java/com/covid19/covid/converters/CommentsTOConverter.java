package com.covid19.covid.converters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.covid19.covid.entities.Comments;
import com.covid19.covid.entities.CountryCovid;
import com.covid19.covid.transferObjects.CommentsTO;

import org.springframework.stereotype.Component;

@Component
public class CommentsTOConverter {
    public CommentsTO fromComments(Comments comments){
        CommentsTO commentsTO = new CommentsTO();
        commentsTO.setComment(comments.getComment());
        commentsTO.setCountryCovidId(comments.getCountryCovid().getId());
        commentsTO.setId(comments.getId());
        commentsTO.setCommentTime(comments.getCommentTime());
        return commentsTO;
    }

    public Comments fromCommentsTO(CommentsTO commentsTO){
        Comments comments = new Comments();
        comments.setComment(commentsTO.getComment());
        CountryCovid countryCovid = new CountryCovid();
        countryCovid.setId(commentsTO.getCountryCovidId());
        comments.setCountryCovid(countryCovid);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        comments.setCommentTime(LocalDateTime.now().format(formatter));
        return comments;
    }
}
