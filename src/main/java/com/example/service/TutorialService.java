package com.example.service;

import com.example.dto.TutorialDto;
import com.example.entity.Tutorial;

import java.util.List;
import java.util.Optional;

public interface TutorialService {
    TutorialDto saveTutorial(TutorialDto tutorialDto);
    List<TutorialDto> getAllTutorials();
    Optional<TutorialDto> getTutorialsById(Integer id);
    Tutorial updateTutorial(Integer id, TutorialDto tutorialDto);
    String deleteTutorial(Integer id);

    //custom methods
    List<TutorialDto> searchByTitle(String title);
    List<TutorialDto> getTutorialsByPublished(Boolean published);

}
