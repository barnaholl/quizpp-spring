package com.theyellowpug.userhandlerservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCurrency {

    @Id
    @GeneratedValue
    private Long id;

    //@ToString.Exclude
    //@EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private QuizUser quizUser;

    @Column(nullable = false)
    private Long score;
}
