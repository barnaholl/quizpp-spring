package com.theyellowpug.gamehandlerservice.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @Column(nullable = false)
    private String type;

    @ElementCollection
    private List<String> playersEnrolled;

    private LocalDateTime expiryDate;

}
