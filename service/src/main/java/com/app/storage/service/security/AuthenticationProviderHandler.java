package com.app.storage.service.security;


import com.app.storage.domain.model.Role;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.service.UserPersistenceService;
import com.app.storage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implementation of {@link AuthenticationProvider}
 */
@Service
public class AuthenticationProviderHandler implements AuthenticationProvider {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationProviderHandler.class);

    @Autowired
    private UserPersistenceService userPersistenceService;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * {@inheritDoc}
     */
    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

        LOG.debug("Loading user with email: {}, and pass: {}", authentication.getPrincipal(), authentication
                .getCredentials());

        final String username = authentication.getPrincipal().toString();
        final String password = authentication.getCredentials().toString();

        final User user = userPersistenceService.findUserByEmail(username);

        if (user != null) {

            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
                throw new InvalidParameterException("Invalid password");
            }

            final CustomUserDetails customUserDetails = new CustomUserDetails(user);
            customUserDetails.setGrantedAuthorities(getAuthorities(user.getRoles()));
            return new UsernamePasswordAuthenticationToken(customUserDetails, user.getPassword(), getAuthorities(user.getRoles()));

        } else {
            throw new UsernameNotFoundException("No user with name: " + username);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));

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
