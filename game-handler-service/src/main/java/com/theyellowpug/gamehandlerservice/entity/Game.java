package com.theyellowpug.gamehandlerservice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private String tag;

    @Column(nullable = false)
    private short difficulty;

    @ElementCollection
    private List<String> tags;


}
