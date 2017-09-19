package com.app.storage.integration.Ebay.config;

import com.app.storage.integration.IntegrationConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Builds headers for ebay api requests
 */
public class EbayAPIRequestHeadersBuilder {

    /** logger. */
    private static final Logger LOG = LoggerFactory.getLogger(EbayAPIRequestHeadersBuilder.class);

    /**
     * Builds all headers for request with type:
     *
     * @param requestType
     *         Type of api request (e.g. AddItem).
     * @return Hashmap of all key/value headers.
     */
    public static MultivaluedMap<String, Object> buildFullHeadersSandbox(final String requestType) {

        LOG.debug("Building full sandbox headers for request: {}", requestType);

        final MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.add(IntegrationConstants.EBAY_COMPATIBILITY_KEY, IntegrationConstants.EBAY_SCHEMA_VERSION_082017);
        headers.add(IntegrationConstants.EBAY_DEV_NAME_KEY, IntegrationConstants.EBAY_DEV_NAME_SANDBOX_VALUE);
        headers.add(IntegrationConstants.EBAY_APP_NAME_KEY, IntegrationConstants.EBAY_APP_NAME_SANDBOX_VALUE);
        headers.add(IntegrationConstants.EBAY_CERT_NAME_KEY, IntegrationConstants.EBAY_CERT_NAME_SANDBOX_VALUE);
        headers.add(IntegrationConstants.EBAY_CALL_NAME_KEY, requestType);
        headers.add(IntegrationConstants.EBAY_SITE_ID_KEY, IntegrationConstants.EBAY_SITE_ID_UK_VALUE);
        headers.add(IntegrationConstants.CONTENT_TYPE_KEY, IntegrationConstants.XML_CONTENT_TYPE_VALUE);
        headers.add("Accept Header", IntegrationConstants.XML_CONTENT_TYPE_VALUE);

        return headers;
    }
}
