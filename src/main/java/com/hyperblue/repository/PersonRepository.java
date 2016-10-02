package com.hyperblue.repository;

import com.hyperblue.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Person Repository
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
