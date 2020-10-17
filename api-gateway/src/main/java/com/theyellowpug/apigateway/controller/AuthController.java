package com.theyellowpug.apigateway.controller;

import com.theyellowpug.apigateway.model.QuizUserModel;
import com.theyellowpug.apigateway.model.UserCredentials;
import com.theyellowpug.apigateway.security.CustomUserDetailsService;
import com.theyellowpug.apigateway.security.JwtTokenServices;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenServices jwtTokenServices;

    private final RestTemplate restTemplate;

    private final CustomUserDetailsService customUserDetailsService;

    private final PasswordEncoder passwordEncoder;

    private final String baseUrl="http://user-handler-service/";

    public AuthController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices, RestTemplate restTemplate, CustomUserDetailsService customUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
        this.restTemplate = restTemplate;
        this.customUserDetailsService = customUserDetailsService;
        this.passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserCredentials data) {
        try {
            String username = data.getUsername();
            // authenticationManager.authenticate calls loadUserByUsername in CustomUserDetailsService
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String token = jwtTokenServices.createToken(username, roles);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("roles", roles);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserCredentials userCredentials) {
        String username = userCredentials.getUsername();
        String password = userCredentials.getPassword();
        String role = userCredentials.getRoles();

        Map<Object, Object> model = new HashMap<>();
        //List<String> errorList = new ArrayList<>();

        if (restTemplate.getForEntity(baseUrl+username, QuizUserModel.class).getBody() != null){
            model.put("correct", false);
            model.put("msg", "Username already exists! Please choose a different username!");
            return ResponseEntity.ok(model);
        }

        /*if(!dataValidator.isValidUsername(username, errorList)) {
            String error = String.join(" , ", errorList);
            String errorMessage = "Username should have " + error + "!";
            model.put("correct", false);
            model.put("msg", errorMessage);
            return ResponseEntity.ok(model);
        }

        if (!dataValidator.isValidPassword(password, errorList)) {
            String error = String.join(" , ", errorList);
            String errorMessage = "Password should contain " + error + "!";
            model.put("correct", false);
            model.put("msg", errorMessage);
            return ResponseEntity.ok(model);
        }*/
        UserCredentials newUserCredentials = UserCredentials.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(role)
                .build();

        restTemplate.postForEntity(baseUrl,newUserCredentials,String.class);
        //TODO:Check

        List<String> roles = Collections.singletonList("ROLE_PLAYER");
        String token = jwtTokenServices.createToken(username, roles);
        model.put("correct", true);
        model.put("username", username);
        model.put("roles", roles);
        model.put("token", token);
        return ResponseEntity.ok(model);
}
}