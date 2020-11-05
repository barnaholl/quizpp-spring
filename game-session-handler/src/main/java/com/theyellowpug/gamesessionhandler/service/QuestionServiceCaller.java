package com.theyellowpug.gamesessionhandler.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuestionServiceCaller {

    private final RestTemplate restTemplate;

    public QuestionServiceCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final String questionHandlerUrl="http://question-handler-service";

    public Long getQuestionId(String tag,Short difficulty){
        return restTemplate.getForObject(questionHandlerUrl+"/"+tag+"/"+difficulty,Long.class);
    }

    public Boolean isAnswerCorrect(Long id, String answer){
        return restTemplate.getForObject(questionHandlerUrl+"/isCorrect/"+id+"/"+answer,Boolean.class);
    }


}
