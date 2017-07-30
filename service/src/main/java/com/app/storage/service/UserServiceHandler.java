package com.app.storage.service;

import com.app.storage.domain.model.Role;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.UserPersistenceMapper;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.repository.UserRepository;
import com.app.storage.persistence.service.UserPersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    /**
     * Constructor.
     *
     * @param userPersistenceService
     *         {@link UserPersistenceService}
     */
    @Autowired
    public UserServiceHandler(final UserPersistenceService userPersistenceService) {

        this.userPersistenceService = userPersistenceService;
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

        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;
        if (user != null) {
            usernamePasswordAuthenticationToken = new
                    UsernamePasswordAuthenticationToken(userEmail, password, getAuthorities(user.getRoles()));
        } else {
            throw new UsernameNotFoundException("No user found with email: " + userEmail);
        }

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            LOG.debug(String.format("Auto login %s successfully!", userEmail));
        } else {

            LOG.debug("Auto login unsuccessful");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User loadUserData(final String userEmail) {

        LOG.debug("Loading user by email: {}", userEmail);

        final User user = userPersistenceService.findUserByEmail(userEmail);

        LOG.debug("Successfully found user: {}", user);

        return user;
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
}
