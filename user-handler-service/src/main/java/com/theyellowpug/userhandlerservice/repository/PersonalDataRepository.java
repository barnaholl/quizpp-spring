package com.theyellowpug.userhandlerservice.repository;

import com.theyellowpug.userhandlerservice.entity.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDataRepository extends JpaRepository<PersonalData,Long> {
}
