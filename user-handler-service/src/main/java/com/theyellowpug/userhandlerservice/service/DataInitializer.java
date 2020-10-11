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
    public void createPersonalData(String emailAddress, Date birthDate,String country, String sex){
        PersonalData personalData= PersonalData.builder()
                .emailAddress(emailAddress)
                .birthDate(birthDate)
                .country(country)
                .sex(sex)
                .build();

        personalDataRepository.save(personalData);
    }

    @Override
    public void run(String... args) throws Exception {
        //createPersonalData("user@quizpp.com",new Date(19960909),"Hungary","Male");
    }
}
