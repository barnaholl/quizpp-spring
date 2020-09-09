package com.theyellowpug.questionhandlerservice.controller;

import com.theyellowpug.questionhandlerservice.entity.Question;
import com.theyellowpug.questionhandlerservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @GetMapping("/difficulty")
    public List<Question> getRandomByTag(){
        return questionRepository.findByDifficultyEquals((short)2);
    }

    @DeleteMapping("/{id}")
    public String deleteQuestionById(@PathVariable("id") Long id){
        questionRepository.deleteById(id);
        return "Successfully deleted";
    }

    @PutMapping("/{id}")
    public String updateQuestionById(@PathVariable("id") Long id,@RequestBody Question question){
        questionRepository.deleteById(id);
        questionRepository.save(question);
        return "Successfully updated";
    }



}
