package com.app.storage.service.security;

import com.app.storage.domain.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Custom user details passed around by spring framework.
 */
public class CustomUserDetails extends User implements UserDetails {

    /** LIst of {@link GrantedAuthority}. */
    private Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

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
    public String getPassword() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
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

    /**
     * Gets LIst of {@link GrantedAuthority}..
     *
     * @return Value of LIst of {@link GrantedAuthority}..
     */
    public Set<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    /**
     * Sets new LIst of {@link GrantedAuthority}..
     *
     * @param grantedAuthorities
     *         New value of LIst of {@link GrantedAuthority}..
     */
    public void setGrantedAuthorities(Set<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }
}
