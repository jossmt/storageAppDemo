package com.app.storage.persistence.service;

import com.app.storage.domain.model.Address;
import com.app.storage.domain.model.User;
import com.app.storage.domain.model.payment.PaymentInformation;
import com.app.storage.domain.model.trade.TradingAccount;
import com.app.storage.persistence.model.AddressPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

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
     * Loads user trading accounts that are setup.
     *
     * @param userEmail
     *         User Identifier.
     * @return list of {@link TradingAccount}
     */
    List<TradingAccount> loadUserTradingAccounts(String userEmail);

    /**
     * Updates user address.
     *
     * @param userEmail
     *         Users email.
     * @param address
     *         {@link Address}
     */
    void updateUserAddress(String userEmail, Address address);

    /**
     * Updates user name's for logged in user
     *
     * @param email
     *         User email.
     * @param firstName
     *         User first name.
     * @param lastName
     *         User last name.
     */
    void updateUsername(String email, String firstName, String lastName);

    /**
     * Updates user payment information.
     *
     * @param userEmail
     *         Users email.
     * @param paymentInformation
     *         Users payment information.
     */
    void updateUserPaymentInformation(String userEmail, PaymentInformation paymentInformation);

    /**
     * Updates user email.
     *
     * @param userEmail
     *         Users email.
     * @param newEmail
     *         Users new email.
     */
    void updateUserEmail(String userEmail, String newEmail);

    /**
     * Updates user password.
     *
     * @param userEmail
     *         Users email.
     * @param password
     *         Users new password.
     */
    void updateUserPassword(String userEmail, String password);
}
