package com.theyellowpug.questionhandlerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RenderedQuestion {
    private Long id;

    private String question;

    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
}
