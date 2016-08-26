package com.hyperblue.repository;

import com.hyperblue.domain.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Reminder Repository
 */
@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    
}
