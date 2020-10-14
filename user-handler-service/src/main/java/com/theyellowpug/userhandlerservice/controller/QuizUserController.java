package com.theyellowpug.userhandlerservice.controller;

import com.theyellowpug.userhandlerservice.entity.QuizUser;
import com.theyellowpug.userhandlerservice.repository.QuizUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class QuizUserController {
    private final QuizUserRepository quizUserRepository;

    public QuizUserController(QuizUserRepository quizUserRepository) {
        this.quizUserRepository = quizUserRepository;
    }

    @GetMapping("/all")
    public List<QuizUser> getAllQuizUser(){
        return quizUserRepository.findAll();
    }

    @PostMapping("")
    public String createNewQuizUser(@RequestBody QuizUser quizUser){
        quizUserRepository.save(quizUser);
        return quizUser.toString()+" saved in the database";
    }



}
