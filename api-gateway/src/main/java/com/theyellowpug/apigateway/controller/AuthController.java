package com.theyellowpug.apigateway.controller;

import com.theyellowpug.apigateway.model.QuizUserModel;
import com.theyellowpug.apigateway.model.UserCredentials;
import com.theyellowpug.apigateway.security.CustomUserDetailsService;
import com.theyellowpug.apigateway.security.JwtTokenServices;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@CrossOrigin
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
        Map<Object, Object> model = new HashMap<>();

        try {
            String username = data.getUsername();

            // authenticationManager.authenticate calls loadUserByUsername in CustomUserDetailsService
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String token = jwtTokenServices.createToken(username, roles);

            model.put("correct", true);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            model.put("correct", false);
            model.put("msg", "Invalid username/password");
            return ResponseEntity.ok(model);
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserCredentials userCredentials) {
        String username = userCredentials.getUsername();

        Map<Object, Object> model = new HashMap<>();

        if (restTemplate.getForEntity(baseUrl+username, QuizUserModel.class).getBody() != null){
            model.put("correct", false);
            model.put("msg", "Username already exists! Please choose a different username!");
            return ResponseEntity.ok(model);
        }

        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
        userCredentials.setRoles(Collections.singletonList("ROLE_PLAYER"));

        restTemplate.postForEntity(baseUrl,userCredentials,String.class);

        List<String> roles = Collections.singletonList("ROLE_PLAYER");
        String token = jwtTokenServices.createToken(username, roles);
        model.put("correct", true);
        model.put("token", token);
        return ResponseEntity.ok(model);
    }
}