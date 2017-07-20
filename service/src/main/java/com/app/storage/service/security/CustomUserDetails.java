package com.app.storage.service.security;

import com.app.storage.domain.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Custom user details allowing obj to implement userdetails and
 * hence be used by spring security methods.
 */
public final class CustomUserDetails extends User implements UserDetails {

    /**
     * Constructor.
     *
     * @param user
     *         {@link User}
     */
    public CustomUserDetails(final User user) {
        super(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUsername() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
