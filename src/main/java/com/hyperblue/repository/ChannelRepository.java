package com.hyperblue.repository;

import com.hyperblue.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Channel Repository
 */
@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

}
