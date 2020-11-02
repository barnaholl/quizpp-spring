package com.theyellowpug.userhandlerservice.controller;

import com.theyellowpug.userhandlerservice.service.UserCurrencyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-currency")
public class UserCurrencyController {

    private final UserCurrencyService userCurrencyService;

    public UserCurrencyController(UserCurrencyService userCurrencyService) {
        this.userCurrencyService = userCurrencyService;
    }

    @GetMapping("/{username}")
    public Long getScoreByUsername(@PathVariable("username") String username){
        return userCurrencyService.getScoreByUsername(username);
    }

    @PutMapping("/{username}/{score}")
    public String addScoreByUsername(@PathVariable("username") String username,@PathVariable("score") Long score){
        userCurrencyService.addScoreByUsername(username, score);
        return score+" score added to user: "+username;
    }
}
