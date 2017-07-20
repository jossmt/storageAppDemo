package com.app.storage.service.security;

import com.app.storage.domain.model.Role;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.service.UserPersistenceService;
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

    @Autowired
    private UserPersistenceService userPersistenceService;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetails loadUserByUsername(final String userEmail) throws UsernameNotFoundException {

        CustomUserDetails customUserDetails = null;

        final User user = userPersistenceService.findUserByEmail(userEmail);

        if (user != null) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            for (Role role : user.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            customUserDetails = new CustomUserDetails(user);
        }

        return customUserDetails;
    }
}
