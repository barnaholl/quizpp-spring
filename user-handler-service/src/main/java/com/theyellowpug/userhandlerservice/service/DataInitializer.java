package com.theyellowpug.userhandlerservice.service;

import com.theyellowpug.userhandlerservice.entity.PersonalData;
import com.theyellowpug.userhandlerservice.entity.QuizUser;
import com.theyellowpug.userhandlerservice.entity.UserRole;
import com.theyellowpug.userhandlerservice.repository.PersonalDataRepository;
import com.theyellowpug.userhandlerservice.repository.QuizUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DataInitializer implements CommandLineRunner {

    private final QuizUserRepository quizUserRepository;

    private final PersonalDataRepository personalDataRepository;

    public DataInitializer(QuizUserRepository quizUserRepository, PersonalDataRepository personalDataRepository) {
        this.quizUserRepository = quizUserRepository;
        this.personalDataRepository = personalDataRepository;
    }

    private void createQuizUser(String username, String password, UserRole userRole){
        QuizUser quizUser= QuizUser.builder()
                .username(username)
                .password(password)
                .userRole(userRole)
                .build();

        quizUserRepository.save(quizUser);
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
        createQuizUser("player","player",UserRole.PLAYER);
        createQuizUser("creator","creator",UserRole.CREATOR);
        createQuizUser("admin","admin",UserRole.ADMIN);

        //createPersonalData("player@quizpp.com",new Date(19960909),"Hungary","Male",quizUserRepository.getByUserRole(UserRole.PLAYER));
    }
}
