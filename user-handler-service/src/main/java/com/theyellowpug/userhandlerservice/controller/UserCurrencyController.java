package com.theyellowpug.userhandlerservice.controller;

import com.theyellowpug.userhandlerservice.service.UserCurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UserCurrency")
public class UserCurrencyController {

    private final UserCurrencyService userCurrencyService;

    public UserCurrencyController(UserCurrencyService userCurrencyService) {
        this.userCurrencyService = userCurrencyService;
    }

    @GetMapping("/{username}")
    public Long getScoreByUsername(@PathVariable("username") String username){
        return userCurrencyService.getScoreByUsername(username);
    }
}
