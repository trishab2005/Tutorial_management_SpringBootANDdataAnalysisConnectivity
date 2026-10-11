package com.example.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class TutorialDto {

    private Integer id;
    private String title;
    private String description;
    // private String published;
    private boolean published;

    public TutorialDto(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }
}
