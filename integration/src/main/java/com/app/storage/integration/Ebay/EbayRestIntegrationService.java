package com.app.storage.integration.Ebay;

import com.app.storage.integration.model.Ebay.Responses.FetchTokenResponseIntegrationModel;
import com.app.storage.integration.model.Ebay.Responses.GetSessionIDResponseIntegrationModel;

/**
 * Handler for REST requests for Ebay API
 */
public interface EbayRestIntegrationService {

    /**
     * Generates a session id.
     */
    GetSessionIDResponseIntegrationModel generateNewSessionID();

    /**
     * Fetch user token.
     *
     * @param sessionId
     *         Session identifier.
     * @return {@link FetchTokenResponseIntegrationModel}
     */
    FetchTokenResponseIntegrationModel fetchUserToken(String sessionId);
}
