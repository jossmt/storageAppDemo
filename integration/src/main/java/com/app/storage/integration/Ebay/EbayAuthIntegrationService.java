package com.app.storage.integration.Ebay;

/**
 * Ebay authentication service.
 */
public interface EbayAuthIntegrationService {

    /**
     * Authenticates new user by generating token and persisting data.
     *
     */
    void authenticateNewUser();
}
