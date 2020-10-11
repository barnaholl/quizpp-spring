package com.theyellowpug.userhandlerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizUser {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String password;

}