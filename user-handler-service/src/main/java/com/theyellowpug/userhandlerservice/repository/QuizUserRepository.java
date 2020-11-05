package com.theyellowpug.userhandlerservice.repository;

import com.theyellowpug.userhandlerservice.entity.QuizUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuizUserRepository extends JpaRepository<QuizUser,Long> {

    QuizUser findByUsername(String username);

}
