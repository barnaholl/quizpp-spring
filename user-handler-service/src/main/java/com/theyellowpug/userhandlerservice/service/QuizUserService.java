package com.theyellowpug.userhandlerservice.service;

import com.theyellowpug.userhandlerservice.entity.QuizUser;
import com.theyellowpug.userhandlerservice.repository.QuizUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizUserService {

    private final QuizUserRepository quizUserRepository;

    public QuizUserService(QuizUserRepository quizUserRepository) {
        this.quizUserRepository = quizUserRepository;
    }

    public List<QuizUser> getAllQuizUser(){
        return quizUserRepository.findAll();
    }

    public QuizUser getQuizUserByUsername(String username){
        return quizUserRepository.findByUsername(username);
    }

    public void createNewQuizUser(QuizUser quizUser){
        quizUserRepository.save(quizUser);
    }
}
