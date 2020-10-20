package com.theyellowpug.apigateway.controller;

import com.theyellowpug.apigateway.model.GameModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/jwtUtils")
public class JwtUtilsController {

    private final String getGameByIdUrl="http://game-handler-service/";

    private  final RestTemplate restTemplate;

    public JwtUtilsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/isUserEnrolled/{gameId}")
    public Boolean currentUser(@PathVariable("gameId") Long gameId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String name = (String) authentication.getPrincipal();

        GameModel gameModel=restTemplate.getForEntity(getGameByIdUrl+gameId, GameModel.class).getBody();

        List<String> playersEnrolled=gameModel.getPlayersEnrolled();

        return playersEnrolled.contains(name);
    }

    @GetMapping("/username")
    public String getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return  (String) authentication.getPrincipal();
    }

}
