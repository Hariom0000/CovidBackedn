package com.covid19.covid.repository;

import com.covid19.covid.entities.Comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepo extends JpaRepository<Comments, Integer>{
    
}
