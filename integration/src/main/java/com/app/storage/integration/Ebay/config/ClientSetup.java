package com.app.storage.integration.Ebay.config;

import com.app.storage.integration.IntegrationConstants;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Handler for ebay api client url target setup.
 */
public class ClientSetup {

    /** Client. */
    private Client client;

    /** Webtarget for api requests. */
    private WebTarget webTarget;

    /**
     * Default constructor.
     */
    public ClientSetup() {
        client = ClientBuilder.newClient();
        webTarget = client.target(IntegrationConstants.EBAY_SANDBOX_URL);
    }


    /**
     * Gets Client..
     *
     * @return Value of Client..
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets new Client..
     *
     * @param client
     *         New value of Client..
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Gets Webtarget for api requests..
     *
     * @return Value of Webtarget for api requests..
     */
    public WebTarget getWebTarget() {
        return webTarget;
    }

    /**
     * Sets new Webtarget for api requests..
     *
     * @param webTarget
     *         New value of Webtarget for api requests..
     */
    public void setWebTarget(WebTarget webTarget) {
        this.webTarget = webTarget;
    }
}
