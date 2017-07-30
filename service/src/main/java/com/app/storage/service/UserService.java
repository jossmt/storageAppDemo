package com.app.storage.service;

import com.app.storage.domain.model.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * User service.
 */
public interface UserService {

    /**
     * Save user.
     *
     * @param user
     *         {@link User}
     * @return User domain model.
     */
    User saveUser(final User user);

    /**
     * Loads user details by username.
     *
     * @param username
     *         Users email.
     * @return {@link User}
     */
    User loadUserByUsername(final String username);

    /**
     * Automatic login function.
     *
     * @param userEmail
     *         User email.
     * @param password
     *         Password.
     */
    void autologin(String userEmail, String password);

    /**
     * Loads user information by unique email.
     *
     * @param userEmail
     *         Users email.
     * @return {@link User}
     */
    User loadUserData(String userEmail);
}