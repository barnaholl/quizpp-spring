package com.theyellowpug.userhandlerservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonalData {
    @Id
    @GeneratedValue
    Long id;

    String emailAddress;

    Date birthDate;

    String sex;

    String country;

    //@ToString.Exclude
    //@EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    QuizUser quizUser;

}
