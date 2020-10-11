package com.theyellowpug.gamesessionhandler.service;

import com.theyellowpug.gamesessionhandler.model.QuestionResult;
import com.theyellowpug.gamesessionhandler.repository.SoloGameSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuestionServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    private final String questionHandlerUrl="http://question-handler-service";

    public Long getQuestionId(String tag,Short difficulty){
        Long result=restTemplate.getForObject(questionHandlerUrl+"/"+tag+"/"+difficulty,Long.class);
        return result;
    }

    public Boolean isAnswerCorrect(String answer){
        Long result=restTemplate.getForObject(questionHandlerUrl+"/"+tag+"/"+difficulty,Long.class);
    }


}
