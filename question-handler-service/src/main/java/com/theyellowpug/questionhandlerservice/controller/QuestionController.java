package com.theyellowpug.questionhandlerservice.controller;

import com.theyellowpug.questionhandlerservice.entity.Question;
import com.theyellowpug.questionhandlerservice.model.RenderedQuestion;
import com.theyellowpug.questionhandlerservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @GetMapping("/{id}")
    public Optional<Question> getAllQuestionById(@PathVariable("id") Long id)
    {
        return questionRepository.findById(id);
    }

    @GetMapping("/{tag}/{difficulty}")
    public RenderedQuestion getRandomQuestionModelByTagAndDifficulty(@PathVariable("tag")String tag, @PathVariable("difficulty") short difficulty) {
        List<Question> questions=questionRepository.findAllByTagsAndDifficultyEquals(tag,difficulty);
        if(questions.size()>0){
            Random random=new Random();

            Question question=questions.get(random.nextInt(questions.size()));

            List<String> questionsOfQuestion=new ArrayList<>();
            questionsOfQuestion.add(question.getCorrectAnswer());
            questionsOfQuestion.add(question.getWrongAnswer1());
            questionsOfQuestion.add(question.getWrongAnswer2());
            questionsOfQuestion.add(question.getWrongAnswer3());

            int currentIndex=random.nextInt(questionsOfQuestion.size());
            String answer1=questionsOfQuestion.get(currentIndex);
            questionsOfQuestion.remove(currentIndex);

            currentIndex=random.nextInt(questionsOfQuestion.size());
            String answer2=questionsOfQuestion.get(currentIndex);
            questionsOfQuestion.remove(currentIndex);

            currentIndex=random.nextInt(questionsOfQuestion.size());
            String answer3=questionsOfQuestion.get(currentIndex);
            questionsOfQuestion.remove(currentIndex);

            currentIndex=random.nextInt(questionsOfQuestion.size());
            String answer4=questionsOfQuestion.get(currentIndex);

            RenderedQuestion renderedQuestion= RenderedQuestion.builder()
                    .id(question.getId())
                    .question(question.getQuestion())
                    .answer1(answer1)
                    .answer2(answer2)
                    .answer3(answer3)
                    .answer4(answer4)
                    .build();

            return renderedQuestion;
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
