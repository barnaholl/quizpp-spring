package com.theyellowpug.apigateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuizUserModel {

    //Long id;
    String username;

    String password;

    ArrayList<String> roles;


}
