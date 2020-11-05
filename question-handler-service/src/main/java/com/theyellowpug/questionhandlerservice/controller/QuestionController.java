package com.theyellowpug.questionhandlerservice.controller;

import com.theyellowpug.questionhandlerservice.entity.Question;
import com.theyellowpug.questionhandlerservice.model.RenderedQuestion;
import com.theyellowpug.questionhandlerservice.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class QuestionController {


    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/")
    public void addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
    }
    @GetMapping("/")
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("/{id}")
    public Optional<Question> getQuestionById(@PathVariable("id") Long id){
        return questionService.getQuestionById(id);
    }

    @GetMapping("/render/{id}")
    public RenderedQuestion getAllQuestionById(@PathVariable("id") Long id){
        return questionService.getAllQuestionById(id);
    }

    @GetMapping("/{tag}/{difficulty}")
    public Long getRandomQuestionIdByTagAndDifficulty(@PathVariable("tag")String tag, @PathVariable("difficulty") short difficulty) {
        return questionService.getRandomQuestionIdByTagAndDifficulty(tag, difficulty);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestionById(@PathVariable("id") Long id){
        questionService.deleteQuestionById(id);
    }

    @PutMapping("/{id}")
    public void updateQuestionById(@PathVariable("id") Long id,@RequestBody Question question){
       questionService.updateQuestionById(id, question);
    }

    @GetMapping("/isCorrect/{id}/{answer}")
    public Boolean isAnswerCorrect(@PathVariable("id") Long id,@PathVariable("answer") String answer){
        return questionService.isAnswerCorrect(id, answer);
    }

}
