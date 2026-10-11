package com.example.repository;

import com.example.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

    //custom query method

    List<Tutorial> findByPublished(Boolean published);
    List<Tutorial> findByTitle(String title);
}
