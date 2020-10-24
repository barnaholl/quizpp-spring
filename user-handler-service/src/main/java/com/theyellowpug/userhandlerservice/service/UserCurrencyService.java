package com.theyellowpug.userhandlerservice.service;

import com.theyellowpug.userhandlerservice.repository.UserCurrencyRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCurrencyService {

    private final UserCurrencyRepository userCurrencyRepository;


    public UserCurrencyService(UserCurrencyRepository userCurrencyRepository) {
        this.userCurrencyRepository = userCurrencyRepository;
    }

    public void addScoreByUsername(String username){

    }
}
