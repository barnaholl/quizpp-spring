package com.theyellowpug.questionhandlerservice.service;

import com.theyellowpug.questionhandlerservice.entity.Question;
import com.theyellowpug.questionhandlerservice.model.RenderedQuestion;
import com.theyellowpug.questionhandlerservice.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void addQuestion(Question question){
        questionRepository.save(question);
    }

    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(Long id){
        return questionRepository.findById(id);
    }
    public RenderedQuestion getAllQuestionById(Long id)
    {
        Question question=questionRepository.getById(id);

        Random random=new Random();

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
    public Long getRandomQuestionIdByTagAndDifficulty(String tag, short difficulty) {
        List<Question> questions=questionRepository.findAllByTagsAndDifficultyEquals(tag,difficulty);
        if(questions.size()>0){
            Random random=new Random();
            Question question=questions.get(random.nextInt(questions.size()));

            return question.getId();
        }
        return null;
    }

    public void deleteQuestionById(Long id){
        questionRepository.deleteById(id);
    }

    public void updateQuestionById(Long id, Question question){
        questionRepository.deleteById(id);
        questionRepository.save(question);
    }

    public Boolean isAnswerCorrect(Long id, String answer){
        return questionRepository.getById(id).getCorrectAnswer().equals(answer);
    }


}
