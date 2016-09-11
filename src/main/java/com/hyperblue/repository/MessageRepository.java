package com.hyperblue.repository;

import com.hyperblue.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Message Repository
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
