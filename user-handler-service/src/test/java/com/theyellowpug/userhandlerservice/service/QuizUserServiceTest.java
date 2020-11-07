package com.theyellowpug.userhandlerservice.service;

import com.theyellowpug.userhandlerservice.entity.QuizUser;
import com.theyellowpug.userhandlerservice.repository.QuizUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase
class QuizUserServiceTest {

    @Autowired
    private QuizUserService quizUserService;

    @Autowired
    private QuizUserRepository quizUserRepository;

    @Test
    public void createNewQuizUserTest(){
        quizUserService.createNewQuizUser(new QuizUser());
        List<QuizUser> quizUserList=quizUserRepository.findAll();
        assertEquals(quizUserList.size(),1);
    }

}