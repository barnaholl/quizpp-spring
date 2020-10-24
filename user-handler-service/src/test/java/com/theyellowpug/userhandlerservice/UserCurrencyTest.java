package com.theyellowpug.userhandlerservice;

import com.theyellowpug.userhandlerservice.repository.UserCurrencyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserCurrencyTest {

    private final UserCurrencyRepository userCurrencyRepository;

    public UserCurrencyTest(UserCurrencyRepository userCurrencyRepository) {
        this.userCurrencyRepository = userCurrencyRepository;
    }

    @Test
    public void addScoreByUserId(){

    }
}
