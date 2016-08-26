package com.hyperblue.repository;

import com.hyperblue.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Task Repository
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
