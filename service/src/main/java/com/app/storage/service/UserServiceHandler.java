package com.app.storage.service;

import com.app.storage.domain.model.Address;
import com.app.storage.domain.model.Role;
import com.app.storage.domain.model.User;
import com.app.storage.domain.model.trade.TradingAccount;
import com.app.storage.persistence.mapper.UserPersistenceMapper;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.repository.UserRepository;
import com.app.storage.persistence.service.UserPersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implementation of {@link UserService}
 */
@Service
public class UserServiceHandler implements UserService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    /** {@link UserPersistenceService}. */
    private final UserPersistenceService userPersistenceService;

    /** {@link AuthenticationProvider}. */
    private final AuthenticationProvider authenticationProvider;


    /**
     * Constructor.
     *
     * @param userPersistenceService
     *         {@link UserPersistenceService}
     */
    @Autowired
    public UserServiceHandler(final UserPersistenceService userPersistenceService,
                              final AuthenticationProvider authenticationProvider) {

        this.userPersistenceService = userPersistenceService;
        this.authenticationProvider = authenticationProvider;
    }


    @Override
    public User saveUser(final User user) {

        LOG.debug("Saving user ", user);

        final User userSaved = userPersistenceService.saveUser(user);

        LOG.debug("Saved user ", userSaved);

        return userSaved;
    }

    @Override
    public User loadUserByUsername(final String useremail) {

        LOG.debug("Loading user details with username: ", useremail);

        final User userDetails = userPersistenceService.findUserByEmail(useremail);

        LOG.debug("Loaded User: ", userDetails);

        return userDetails;
    }

    @Override
    public void autologin(final String userEmail, final String password) {

        LOG.debug("Attempting auto login with {}, pass: {}", userEmail, password);

        final User user = userPersistenceService.findUserByEmail(userEmail);

        if (user != null) {
            final Authentication authentication = new UsernamePasswordAuthenticationToken(userEmail, password);
            authenticationProvider.authenticate(authentication);
        } else {
            throw new UsernameNotFoundException("Unable to find user with email: " + userEmail);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User loadUserStorage(final String userEmail) {

        LOG.debug("Loading user by email: {}", userEmail);

        final User user = userPersistenceService.findUserByEmailLoadStorage(userEmail);

        LOG.debug("Successfully found user: {}", user);

        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User loadUserProfile(final String userEmail) {

        LOG.debug("Loading user by email: {}", userEmail);

        final User user = userPersistenceService.findUserByEmailLoadProfile(userEmail);

        LOG.debug("Successfully found user: {}", user);

        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TradingAccount> loadUserTradingAccounts(final String userEmail) {

        LOG.debug("Loading user trading accounts by email: {}", userEmail);

        final List<TradingAccount> tradingAccounts = userPersistenceService.loadUserTradingAccounts(userEmail);

        LOG.debug("Successfully found user trading accounts: {}", tradingAccounts);

        return tradingAccounts;
    }

    /**
     * Sets granted authorities.
     *
     * @param roles
     *         List of user roles.
     * @return Set of {@link GrantedAuthority}
     */
    private Set<GrantedAuthority> getAuthorities(final List<Role> roles) {

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : roles) {

            LOG.debug("Setting role: {}", role.getName());
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }

        return grantedAuthorities;
    }

    /**
     * {@inheritDoc}
     */
    public void updateUserAddress(final String userEmail, final Address address) {

        LOG.debug("Updating address to {} for user {}", address, userEmail);

        userPersistenceService.updateUserAddress(userEmail, address);

        LOG.debug("Successfully updated address");
    }
}
