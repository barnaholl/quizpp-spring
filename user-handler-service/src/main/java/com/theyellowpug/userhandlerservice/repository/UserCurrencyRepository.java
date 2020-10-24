package com.theyellowpug.userhandlerservice.repository;

import com.theyellowpug.userhandlerservice.entity.QuizUser;
import com.theyellowpug.userhandlerservice.entity.UserCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCurrencyRepository extends JpaRepository<UserCurrency, Long> {
    UserCurrency getById(QuizUser quizUser);
}
