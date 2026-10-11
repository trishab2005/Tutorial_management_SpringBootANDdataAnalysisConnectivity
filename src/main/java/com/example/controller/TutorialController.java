package com.example.controller;

import com.example.dto.TutorialDto;
import com.example.entity.Tutorial;
import com.example.service.TutorialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TutorialController {

    private final TutorialService tutorialService;

    // 1. Get all tutorials
    @GetMapping
    public ResponseEntity<List<TutorialDto>> getAllTutorials() {
        return ResponseEntity.ok(tutorialService.getAllTutorials());
    }

    // 2. Create a tutorial
    @PostMapping
    public ResponseEntity<TutorialDto> createTutorial(@RequestBody TutorialDto tutorialDto) {
        return new ResponseEntity<>(tutorialService.saveTutorial(tutorialDto), HttpStatus.CREATED);
    }

    // 3. Get a tutorial by ID
    @GetMapping("/{id}")
    public ResponseEntity<TutorialDto> getTutorialById(@PathVariable Integer id) {

        return tutorialService.getTutorialsById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. Update a tutorial
    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable Integer id, @RequestBody TutorialDto tutorialDto) {
        try {
            Tutorial updatedTutorial = tutorialService.updateTutorial(id, tutorialDto);
            return ResponseEntity.ok(updatedTutorial);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. Delete a tutorial
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTutorial(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(tutorialService.deleteTutorial(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 6. Search tutorials by exact title
    @GetMapping("/search")
    public ResponseEntity<List<TutorialDto>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(tutorialService.searchByTitle(title));
    }

    // 7. Get tutorials by published status
    @GetMapping("/published")
    public ResponseEntity<List<TutorialDto>> getTutorialsByPublished(@RequestParam Boolean published) {
        return ResponseEntity.ok(tutorialService.getTutorialsByPublished(published));
    }
}
