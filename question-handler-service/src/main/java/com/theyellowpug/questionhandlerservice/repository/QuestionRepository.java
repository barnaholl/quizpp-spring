package com.theyellowpug.questionhandlerservice.repository;

import com.theyellowpug.questionhandlerservice.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
