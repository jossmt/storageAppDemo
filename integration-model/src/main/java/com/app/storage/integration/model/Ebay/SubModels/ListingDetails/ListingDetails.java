package com.app.storage.integration.model.Ebay.SubModels.ListingDetails;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Item listing details.
 */
@XmlRootElement(name = "ListingDetails")
public class ListingDetails {

    /** Offer price at which listing is auto sold. */
    @XmlElement(name = "BestOfferAutoAcceptPrice")
    private Double bestOfferAutoAcceptPrice;

    /** Offer price at which offer is auto ignored. */
    @XmlElement(name = "MinimumBestOfferPrice")
    private Double minimumBestOfferPrice;

    /** Currency of listing. */
    @XmlAttribute(name = "currencyID")
    private CurrencyCodeType currencyCodeType;


    /**
     * Gets Offer price at which listing is auto sold..
     *
     * @return Value of Offer price at which listing is auto sold..
     */
    public Double getBestOfferAutoAcceptPrice() {
        return bestOfferAutoAcceptPrice;
    }

    /**
     * Gets Offer price at which offer is auto ignored..
     *
     * @return Value of Offer price at which offer is auto ignored..
     */
    public Double getMinimumBestOfferPrice() {
        return minimumBestOfferPrice;
    }

    /**
     * Sets new Offer price at which listing is auto sold..
     *
     * @param bestOfferAutoAcceptPrice
     *         New value of Offer price at which listing is auto sold..
     */
    public void setBestOfferAutoAcceptPrice(Double bestOfferAutoAcceptPrice) {
        this.bestOfferAutoAcceptPrice = bestOfferAutoAcceptPrice;
    }

    /**
     * Sets new Offer price at which offer is auto ignored..
     *
     * @param minimumBestOfferPrice
     *         New value of Offer price at which offer is auto ignored..
     */
    public void setMinimumBestOfferPrice(Double minimumBestOfferPrice) {
        this.minimumBestOfferPrice = minimumBestOfferPrice;
    }

    /**
     * Sets new Currency of listing..
     *
     * @param currencyCodeType
     *         New value of Currency of listing..
     */
    public void setCurrencyCodeType(CurrencyCodeType currencyCodeType) {
        this.currencyCodeType = currencyCodeType;
    }

    /**
     * Gets Currency of listing..
     *
     * @return Value of Currency of listing..
     */
    public CurrencyCodeType getCurrencyCodeType() {
        return currencyCodeType;
    }
}
