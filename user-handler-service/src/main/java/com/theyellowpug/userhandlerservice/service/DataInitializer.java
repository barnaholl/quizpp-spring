package com.theyellowpug.userhandlerservice.service;

import com.theyellowpug.userhandlerservice.entity.PersonalData;
import com.theyellowpug.userhandlerservice.entity.QuizUser;
import com.theyellowpug.userhandlerservice.entity.UserRole;
import com.theyellowpug.userhandlerservice.repository.PersonalDataRepository;
import com.theyellowpug.userhandlerservice.repository.QuizUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
public class DataInitializer implements CommandLineRunner {

    private final QuizUserRepository quizUserRepository;

    private final PersonalDataRepository personalDataRepository;

    private final PasswordEncoder passwordEncoder;

    public DataInitializer(QuizUserRepository quizUserRepository, PersonalDataRepository personalDataRepository) {
        this.quizUserRepository = quizUserRepository;
        this.personalDataRepository = personalDataRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    private void createQuizUser(String username, String password, String userRole){ //UserRole
        QuizUser quizUser= QuizUser.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(Collections.singletonList(userRole)) //TODO:check
                .build();

        quizUserRepository.saveAndFlush(quizUser);
    }

    private void createPersonalData(String emailAddress, Date birthDate, String country, String sex,QuizUser quizUser){
        PersonalData personalData= PersonalData.builder()
                .emailAddress(emailAddress)
                .birthDate(birthDate)
                .country(country)
                .sex(sex)
                .quizUser(quizUser)
                .build();

        personalDataRepository.save(personalData);
    }

    @Override
    public void run(String... args) throws Exception {
        createQuizUser("player","player","ROLE_PLAYER");
        createQuizUser("creator","creator","ROLE_CREATOR");
        createQuizUser("admin","admin","ROLE_ADMIN");

        //createPersonalData("player@quizpp.com",new Date(),"Hungary","Male",quizUserRepository.findByUsername("player"));
    }
}
