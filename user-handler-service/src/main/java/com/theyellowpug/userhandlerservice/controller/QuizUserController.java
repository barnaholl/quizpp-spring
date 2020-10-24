package com.theyellowpug.userhandlerservice.controller;

import com.theyellowpug.userhandlerservice.entity.QuizUser;
import com.theyellowpug.userhandlerservice.repository.QuizUserRepository;
import com.theyellowpug.userhandlerservice.service.QuizUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizUserController {
    private final QuizUserService quizUserService;

    public QuizUserController(QuizUserService quizUserService) {
        this.quizUserService = quizUserService;
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
    public String createNewQuizUser(@RequestBody QuizUser quizUser){
        quizUserService.createNewQuizUser(quizUser);
        return quizUser.toString()+" saved in the database";
    }

}
