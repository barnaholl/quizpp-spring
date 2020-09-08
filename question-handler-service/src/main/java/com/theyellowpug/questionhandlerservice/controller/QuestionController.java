package com.theyellowpug.questionhandlerservice.controller;

import com.theyellowpug.questionhandlerservice.entity.Question;
import com.theyellowpug.questionhandlerservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("")
    public String addQuestion(@RequestBody Question question){
        questionRepository.save(question);
        return "Success";
    }
    @GetMapping("/all")
    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }
    @DeleteMapping("{id}")
    public String deleteQuestionById(@PathVariable("id") long id){
        questionRepository.deleteById(id);
        return "Successfull deleted";
    }



}
