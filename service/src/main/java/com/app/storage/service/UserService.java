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
     * @return {@link UserDetails}
     */
    UserDetails loadUserByUsername(final String username);

    /**
     * Find logged in username.
     *
     * @return Current user logged in username.
     */
    String findLoggedInUsername();

    /**
     * Automatic login function.
     *
     * @param userEmail
     *         User email.
     * @param password
     *         Password.
     */
    void autologin(String userEmail, String password);
}
