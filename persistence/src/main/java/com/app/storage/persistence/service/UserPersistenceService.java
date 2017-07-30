package com.app.storage.persistence.service;

import com.app.storage.domain.model.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * User persistence service.
 */
public interface UserPersistenceService {

    /**
     * Save user to database.
     *
     * @param user
     *         {@link User}
     * @return User.
     */
    User saveUser(final User user);

    /**
     * Loads userdetails object by username.
     *
     * @param username
     *         Users email.
     * @return {@link UserDetails}
     */
    User findUserByEmail(final String username);
}