package com.app.storage.controller.security.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

/**
 * Login url authentication policy implementation.
 */
public class UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(UrlAuthenticationSuccessHandler.class);

    /** {@link RedirectStrategy}. */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * Default constructor
     */
    public UrlAuthenticationSuccessHandler() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication
            authentication) throws IOException, ServletException {

        handleRequest(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    /**
     * Handles authentication request.
     *
     * @param request
     *         {@link HttpServletRequest}
     * @param response
     *         {@link HttpServletResponse}
     * @param authentication
     *         {@link Authentication}
     * @throws IOException
     *         {@link IOException}
     */
    protected void handleRequest(final HttpServletRequest request, final HttpServletResponse response,
                                 final Authentication authentication) throws IOException {

        final String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            LOG.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    /**
     * Determines redirect target URL.
     *
     * @param authentication
     *         {@link Authentication}
     * @return Redirect URL.
     */
    protected String determineTargetUrl(final Authentication authentication) {
        boolean isUser = false;
        boolean isAdmin = false;
        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (final GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("USER")) {
                isUser = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ADMIN")) {
                isAdmin = true;
                break;
            }
        }

        if (isUser) {
            return "/home";
        } else if (isAdmin) {
            return "/console";
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * Removes temporary authentication-related data which may have been stored in the session
     * during the authentication process.
     */
    protected final void clearAuthenticationAttributes(final HttpServletRequest request) {
        final HttpSession session = request.getSession(false);

        if (session == null) {
            return;
        }

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
