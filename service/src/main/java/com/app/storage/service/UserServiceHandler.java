package com.app.storage.service;

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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Implementation of {@link UserService}
 */
@Service
public class UserServiceHandler implements UserService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    /** {@link AuthenticationManager} */
    private AuthenticationManager authenticationManager;

    /** {@link UserDetailsService} */
    private UserDetailsService userDetailsService;

    /** {@link UserPersistenceService}. */
    private final UserPersistenceService userPersistenceService;

    /**
     * Constructor.
     *
     * @param userPersistenceService
     *         {@link UserPersistenceService}
     */
    @Autowired
    public UserServiceHandler(final UserPersistenceService userPersistenceService,
                              final AuthenticationManager authenticationManager,
                              final UserDetailsService userDetailsService) {

        this.userPersistenceService = userPersistenceService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }


    @Override
    public User saveUser(final User user) {

        LOG.debug("Saving user ", user);

        final User userSaved = userPersistenceService.saveUser(user);

        LOG.debug("Saved user ", userSaved);

        return userSaved;
    }

    @Override
    public UserDetails loadUserByUsername(final String useremail) {

        LOG.debug("Loading user details with username: ", useremail);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(useremail);

        LOG.debug("Loaded UserDetails: ", userDetails);

        return userDetails;
    }

    @Override
    public String findLoggedInUsername() {

        LOG.debug("Finding logged in users name.");

        String username = null;
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            username = ((UserDetails) userDetails).getUsername();
        }

        LOG.debug("Returning user name : ", username);

        return username;
    }

    @Override
    public void autologin(final String userEmail, final String password) {

        LOG.debug("Attempting auto login with {}, pass: {}", userEmail, password);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
                UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            LOG.debug(String.format("Auto login %s successfully!", userEmail));
        } else {
            LOG.debug("Auto login unsuccessful");
        }
    }
}
