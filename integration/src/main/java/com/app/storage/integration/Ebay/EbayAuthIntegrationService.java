package com.app.storage.integration.Ebay;

/**
 * Ebay authentication service.
 */
public interface EbayAuthIntegrationService {

    /**
     * Authenticates new user by generating token and persisting data.
     *
     * @return Loging redirect url.
     */
    String authenticateNewUser();

    /**
     * Update users authorisation token and link to trading account.
     */
    void updateUserAuthToken(String sessionIdEncoded);
}
