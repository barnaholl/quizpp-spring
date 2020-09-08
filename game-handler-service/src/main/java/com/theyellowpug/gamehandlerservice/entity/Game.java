package com.theyellowpug.gamehandlerservice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Game {
    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    public String title;

    public String description;

    @Column(nullable = false)
    public String tag;

    @Column(nullable = false)
    public short difficulty;


}
