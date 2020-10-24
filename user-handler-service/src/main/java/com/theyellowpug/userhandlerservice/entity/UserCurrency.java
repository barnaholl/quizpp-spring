package com.theyellowpug.userhandlerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCurrency {

    @Id
    @Column(nullable = false)
    @OneToOne
    private QuizUser user;

    @Column(nullable = false)
    private Long score;
}
