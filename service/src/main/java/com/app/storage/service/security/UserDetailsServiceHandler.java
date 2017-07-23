package com.app.storage.service.security;

import com.app.storage.domain.model.Role;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.service.UserPersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserDetails}
 */
@Service
public class UserDetailsServiceHandler implements UserDetailsService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceHandler.class);

    @Autowired
    private UserPersistenceService userPersistenceService;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetails loadUserByUsername(final String userEmail) throws UsernameNotFoundException {

        LOG.debug("Loading user with email: {}", userEmail);

        CustomUserDetails customUserDetails = null;

        final User user = userPersistenceService.findUserByEmail(userEmail);
        if (user != null) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            for (Role role : user.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            customUserDetails = new CustomUserDetails(user);
        }

        LOG.debug("Successfully loaded user: {}", user);

        return customUserDetails;
    }
}
