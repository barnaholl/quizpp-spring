package com.theyellowpug.questionhandlerservice.repository;

import com.theyellowpug.questionhandlerservice.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    List<Question> findAllByTagsAndDifficultyEquals(String tag, short difficulty);
}
