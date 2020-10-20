package com.theyellowpug.apigateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameModel {

    private Long id;

    private String title;

    private String description;

    private String tag;

    private short difficulty;

    private String type;

    private List<String> playersEnrolled;
}
