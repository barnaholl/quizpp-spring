package com.theyellowpug.questionhandlerservice.controller;

import com.theyellowpug.questionhandlerservice.entity.Question;
import com.theyellowpug.questionhandlerservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping()
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/")
    public String addQuestion(@RequestBody Question question){
        questionRepository.save(question);
        return "Success";
    }
    @GetMapping("/")
    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    @GetMapping("/{tag}/{difficulty}")
    public Question getRandomByTagAndDifficulty(@PathVariable("tag")String tag, @PathVariable("difficulty") short difficulty) {
        List<Question> questions=questionRepository.findAllByTagsAndDifficultyEquals(tag,difficulty);
        if(questions.size()>0){
            Random random=new Random();
            return questions.get(random.nextInt(questions.size()));
        }
        return null;
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
