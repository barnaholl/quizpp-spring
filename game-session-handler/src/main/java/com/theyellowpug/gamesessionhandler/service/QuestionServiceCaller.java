package com.theyellowpug.gamesessionhandler.service;

import com.theyellowpug.gamesessionhandler.model.QuestionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuestionServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    private final String questionHandlerUrl="http://question-handler-service";

    public Long getQuestionId(String tag,Short difficulty){
        QuestionResult result=restTemplate.getForEntity(questionHandlerUrl+"/"+tag+"/"+difficulty,QuestionResult.class).getBody();
        return result.getId();
    }

}