package com.theyellowpug.apigateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegistrationData {
    QuizUserModel quizUser;
    PersonalData personalData;
}

