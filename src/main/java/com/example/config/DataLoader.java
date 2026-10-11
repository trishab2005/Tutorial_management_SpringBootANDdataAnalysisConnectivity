package com.example.config;

import com.example.entity.Tutorial;
import com.example.repository.TutorialRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final TutorialRepository tutorialRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker fake = new Faker();
        for (int i = 0; i < 100; i++) {
            Tutorial tutorial = new Tutorial(
                    fake.book().title(),
                    fake.lorem().sentence(),
                    fake.bool().bool()
            );
            tutorialRepository.save(tutorial);
        }
    }
}
