package com.app.storage.integration.model.Ebay;

/**
 * Ebay request types used by this service.
 */
public enum EbayRequestType {

    GET_SESSION_ID("GetSessionID"),

    FETCH_TOKEN("FetchToken"),

    ADD_ITEM("AddItem");


    /** Request type. */
    private String requestType;

    /**
     * Constructor.
     *
     * @param requestType
     *         Type of api request.
     */
    EbayRequestType(final String requestType) {
        this.requestType = requestType;
    }

    /**
     * Gets Request type..
     *
     * @return Value of Request type..
     */
    public String getRequestType() {
        return requestType;
    }
}
