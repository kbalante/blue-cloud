package com.hyperblue.repository;

import com.hyperblue.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User Repository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find a user using an email address
     * @param email email address
     * @return the user associated to the email or null
     */
    User findOneByEmail(String email);

    /**
     * Find a user using an email and password.
     * @param email email
     * @param passwordEncryped password
     * @return user associated to email and password or null
     */
    User findOneByEmailAndPasswordEncrypted(String email, String passwordEncryped);
}
