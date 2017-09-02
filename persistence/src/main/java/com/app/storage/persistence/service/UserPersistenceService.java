package com.app.storage.persistence.service;

import com.app.storage.domain.model.Address;
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
    User saveUser(User user);

    /**
     * Loads userdetails object by username.
     *
     * @param username
     *         Users email.
     * @return {@link UserDetails}
     */
    User findUserByEmail(String username);

    /**
     * Loads userdetails object by username with storage items.
     *
     * @param username
     *         Users email.
     * @return {@link UserDetails}
     */
    User findUserByEmailLoadStorage(String username);

    /**
     * Loads userdetails object by username with profile info.
     *
     * @param username
     *         Users email.
     * @return {@link UserDetails}
     */
    User findUserByEmailLoadProfile(String username);

    /**
     * Updates user address.
     *
     * @param userEmail
     *         Users email.
     * @param address
     *         {@link Address}
     */
    void updateUserAddress(String userEmail, Address address);
}
