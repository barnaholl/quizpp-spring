package com.theyellowpug.apigateway.security;

import com.theyellowpug.apigateway.model.QuizUserModel;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private RestTemplate restTemplate;

    public CustomUserDetailsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final String baseUrl="http://user-handler-service/";

    /**
     * Loads the user from the DB and converts it to Spring Security's internal User object.
     * Spring will call this code to retrieve a user upon login from the DB.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QuizUserModel user = restTemplate.getForEntity(baseUrl+username,QuizUserModel.class).getBody();
        //new UsernameNotFoundException("Username: " + username + " not found");

        return new User(user.getUsername(), user.getPassword(),
                user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}
