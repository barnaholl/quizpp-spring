package com.theyellowpug.gamesessionhandler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuestionServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    private final String questionHandlerUrl="http://question-handler-service";

    public Long getQuestionId(String tag,Short difficulty){
        return restTemplate.getForObject(questionHandlerUrl+"/"+tag+"/"+difficulty,Long.class);
    }

    public Boolean isAnswerCorrect(Long id, String answer){
        return restTemplate.getForObject(questionHandlerUrl+"/isCorrect/"+id+"/"+answer,Boolean.class);
    }


}
