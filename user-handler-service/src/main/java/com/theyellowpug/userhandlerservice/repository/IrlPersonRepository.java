package com.theyellowpug.userhandlerservice.repository;

import com.theyellowpug.userhandlerservice.entity.IrlPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IrlPersonRepository extends JpaRepository<IrlPerson,Long> {
}
