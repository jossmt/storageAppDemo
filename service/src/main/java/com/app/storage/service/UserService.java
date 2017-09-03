package com.app.storage.service;

import com.app.storage.domain.model.Address;
import com.app.storage.domain.model.User;
import com.app.storage.domain.model.trade.TradingAccount;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

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
    User loadUserStorage(String userEmail);

    /**
     * Loads user information by unique email.
     *
     * @param userEmail
     *         Users email.
     * @return {@link User}
     */
    User loadUserProfile(String userEmail);

    /**
     * Loads user information by unique email.
     *
     * @param userEmail
     *         Users email.
     * @return {@link User}
     */
    List<TradingAccount> loadUserTradingAccounts(String userEmail);

    /**
     * Updates address for given user.
     *
     * @param userEmail
     *         User Unique Reference
     * @param address
     *         {@link Address}
     */
    void updateUserAddress(String userEmail, Address address);
}
