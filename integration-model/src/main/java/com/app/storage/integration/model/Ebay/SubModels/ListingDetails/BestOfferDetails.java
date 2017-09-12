package com.app.storage.integration.model.Ebay.SubModels.ListingDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Best offer details.
 */
@XmlRootElement(name = "BestOfferDetails")
public class BestOfferDetails {

    /** Whether best offer option is available to buyer. */
    @XmlElement(name = "BestOfferEnabled")
    private boolean bestOfferEnabled;

    /**
     * Sets new Whether best offer option is available to buyer..
     *
     * @param bestOfferEnabled
     *         New value of Whether best offer option is available to buyer..
     */
    public void setBestOfferEnabled(boolean bestOfferEnabled) {
        this.bestOfferEnabled = bestOfferEnabled;
    }

    /**
     * Gets Whether best offer option is available to buyer..
     *
     * @return Value of Whether best offer option is available to buyer..
     */
    public boolean isBestOfferEnabled() {
        return bestOfferEnabled;
    }
}
