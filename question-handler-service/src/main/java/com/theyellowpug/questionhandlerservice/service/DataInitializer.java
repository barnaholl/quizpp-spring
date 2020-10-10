package com.theyellowpug.questionhandlerservice.service;

import com.theyellowpug.questionhandlerservice.entity.Question;
import com.theyellowpug.questionhandlerservice.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DataInitializer implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    public DataInitializer(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void createQuestion(String question, String correctAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, short difficulty, List<String> tags){
        Question newQuestion= Question.builder()
                .question(question)
                .correctAnswer(correctAnswer)
                .wrongAnswer1(wrongAnswer1)
                .wrongAnswer2(wrongAnswer2)
                .wrongAnswer3(wrongAnswer3)
                .difficulty(difficulty)
                .tags(tags)
                .build();
        questionRepository.save(newQuestion);
    }

    @Override
    public void run(String... args) throws Exception {
        createQuestion("pick A","A","B","C","D", (short) 1,new ArrayList<>(Arrays.asList(new String[]{"test", "general"})));
        createQuestion("pick B","B","A","C","D", (short) 1,new ArrayList<>(Arrays.asList(new String[]{"test", "general"})));
        createQuestion("pick C","C","B","A","D", (short) 1,new ArrayList<>(Arrays.asList(new String[]{"test", "general"})));
        createQuestion("pick D","D","B","A","C", (short) 1,new ArrayList<>(Arrays.asList(new String[]{"test", "general"})));

    }
}
