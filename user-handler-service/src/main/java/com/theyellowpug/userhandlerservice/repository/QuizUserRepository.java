package com.theyellowpug.userhandlerservice.repository;

import com.theyellowpug.userhandlerservice.entity.QuizUser;
import com.theyellowpug.userhandlerservice.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuizUserRepository extends JpaRepository<QuizUser,Long> {

    QuizUser getByRoles(UserRole roles);

    QuizUser findByUsername(String username);

}
