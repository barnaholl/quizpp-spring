package com.theyellowpug.userhandlerservice.service;

import com.theyellowpug.userhandlerservice.entity.QuizUser;
import com.theyellowpug.userhandlerservice.entity.UserCurrency;
import com.theyellowpug.userhandlerservice.repository.UserCurrencyRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCurrencyService {

    private final UserCurrencyRepository userCurrencyRepository;
    private final QuizUserService quizUserService;

    public UserCurrencyService(UserCurrencyRepository userCurrencyRepository, QuizUserService quizUserService) {
        this.userCurrencyRepository = userCurrencyRepository;
        this.quizUserService = quizUserService;
    }

    public void addScoreByUsername(String username,Long score){
        QuizUser quizUser=quizUserService.getQuizUserByUsername(username);
        UserCurrency userCurrency=userCurrencyRepository.getById(quizUser);
        userCurrency.setScore(userCurrency.getScore()+score);
    }

    public void initUserCurrency(QuizUser quizUser){
        UserCurrency userCurrency= UserCurrency.builder().score((long) 0).quizUser(quizUser).build();
        userCurrencyRepository.save(userCurrency);
    }
}
