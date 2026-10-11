package com.example.service.impl;

import com.example.dto.TutorialDto;
import com.example.entity.Tutorial;
import com.example.repository.TutorialRepository;
import com.example.service.TutorialService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TutorialServiceImpl implements TutorialService {

    private final ModelMapper modelMapper;
    private final TutorialRepository tutorialRepository;


    @Override
    public TutorialDto saveTutorial(TutorialDto tutorialDto) {
        Tutorial t = tutorialRepository.save(modelMapper.map(tutorialDto, Tutorial.class));
        return modelMapper.map(t, TutorialDto.class);
    }

    @Override
    public List<TutorialDto> getAllTutorials() {
        List<Tutorial> all = tutorialRepository.findAll();
        return all.stream().map(t -> modelMapper.map(t, TutorialDto.class)).toList();
    }

    @Override
    public Optional<TutorialDto> getTutorialsById(Integer id) {
        return tutorialRepository.findById(id).map(t -> modelMapper.map(t, TutorialDto.class));

    }

    @Override
    public Tutorial updateTutorial(Integer id, TutorialDto tutorialDto) {
        Tutorial tutorial = tutorialRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Tutorial not found with id: " + id));

        tutorial.setTitle(tutorialDto.getTitle());
        tutorial.setDescription(tutorialDto.getDescription());
        tutorial.setPublished(tutorialDto.isPublished());

        return tutorialRepository.save(tutorial);
    }

    @Override
    public String deleteTutorial(Integer id) {
        Tutorial tutorial = tutorialRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Tutorial not found with id: " + id));

        tutorialRepository.delete(tutorial);

        return "Tutorial deleted successfully with id: " + id;
    }

    @Override
    public List<TutorialDto> searchByTitle(String title) {
        List<Tutorial> tutorials = tutorialRepository.findByTitle(title);

        return tutorials.stream()
                .map(t -> modelMapper.map(t, TutorialDto.class))
                .toList();
    }

    @Override
    public List<TutorialDto> getTutorialsByPublished(Boolean published) {
        return tutorialRepository.findByPublished(published)
                .stream()
                .map(t -> modelMapper.map(t, TutorialDto.class))
                .toList();
    }
}
