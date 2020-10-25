package com.theyellowpug.userhandlerservice.service;

import com.theyellowpug.userhandlerservice.entity.PersonalData;
import com.theyellowpug.userhandlerservice.entity.QuizUser;
import com.theyellowpug.userhandlerservice.repository.PersonalDataRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonalDataService {
    private final PersonalDataRepository personalDataRepository;

    public PersonalDataService(PersonalDataRepository personalDataRepository) {
        this.personalDataRepository = personalDataRepository;
    }

    public void initPersonalData(QuizUser quizUser, PersonalData personalData){
        personalData.setQuizUser(quizUser);
        personalDataRepository.save(personalData);
    }
}
