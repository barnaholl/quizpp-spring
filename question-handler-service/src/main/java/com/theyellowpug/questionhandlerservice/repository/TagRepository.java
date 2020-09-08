package com.theyellowpug.questionhandlerservice.repository;

import com.theyellowpug.questionhandlerservice.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {

}
