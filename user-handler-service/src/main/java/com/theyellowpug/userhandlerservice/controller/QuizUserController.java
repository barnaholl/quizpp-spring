package com.theyellowpug.userhandlerservice.controller;

import com.theyellowpug.userhandlerservice.entity.GameHistory;
import com.theyellowpug.userhandlerservice.entity.PersonalData;
import com.theyellowpug.userhandlerservice.entity.QuizUser;
import com.theyellowpug.userhandlerservice.entity.UserCurrency;
import com.theyellowpug.userhandlerservice.model.RegistrationData;
import com.theyellowpug.userhandlerservice.repository.QuizUserRepository;
import com.theyellowpug.userhandlerservice.service.GameHistoryService;
import com.theyellowpug.userhandlerservice.service.PersonalDataService;
import com.theyellowpug.userhandlerservice.service.QuizUserService;
import com.theyellowpug.userhandlerservice.service.UserCurrencyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizUserController {
    private final QuizUserService quizUserService;
    private final UserCurrencyService userCurrencyService;
    private final PersonalDataService personalDataService;
    private final GameHistoryService gameHistoryService;

    public QuizUserController(QuizUserService quizUserService, UserCurrencyService userCurrencyService, PersonalDataService personalDataService, GameHistoryService gameHistoryService) {
        this.quizUserService = quizUserService;
        this.userCurrencyService = userCurrencyService;
        this.personalDataService = personalDataService;
        this.gameHistoryService = gameHistoryService;
    }

    @GetMapping("/all")
    public List<QuizUser> getAllQuizUser(){
        return quizUserService.getAllQuizUser();
    }

    @GetMapping("/{username}")
    public QuizUser getQuizUserByUsername(@PathVariable("username") String username){
        return quizUserService.getQuizUserByUsername(username);
    }

    @PostMapping("")
    public String createNewQuizUser(@RequestBody RegistrationData registrationData){
        QuizUser quizUser= QuizUser.builder()
                .id(registrationData.getId())
                .username(registrationData.getUsername())
                .password(registrationData.getPassword())
                .roles(registrationData.getRoles())
                .build();

        PersonalData personalData= PersonalData.builder()
                .emailAddress(registrationData.getEmailAddress())
                .birthDate(registrationData.getBirthDate())
                .country(registrationData.getCountry())
                .sex(registrationData.getSex())
                .build();

        quizUserService.createNewQuizUser(quizUser);
        userCurrencyService.initUserCurrency(quizUser);
        personalDataService.initPersonalData(quizUser,personalData);
        gameHistoryService.initGameHistory(quizUser);
        return quizUser.toString()+" saved in the database";
    }

}
