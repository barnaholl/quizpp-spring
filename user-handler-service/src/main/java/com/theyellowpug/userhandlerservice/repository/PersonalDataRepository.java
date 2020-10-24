package com.theyellowpug.userhandlerservice.repository;

import com.theyellowpug.userhandlerservice.entity.PersonalData;
import com.theyellowpug.userhandlerservice.entity.QuizUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDataRepository extends JpaRepository<PersonalData, Long> {

}
