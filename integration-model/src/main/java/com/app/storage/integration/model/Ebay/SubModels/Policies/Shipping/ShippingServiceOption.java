package com.app.storage.integration.model.Ebay.SubModels.Policies.Shipping;

import com.app.storage.integration.model.Ebay.SubModels.ListingDetails.CurrencyCodeType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * International shipping service options.
 */
public class ShippingServiceOption {

    /** Shipping service code reference. */
    @XmlElement(name = "ShippingService")
    private ShippingServiceCode shippingServiceCode;

    /** Shipping service cost. */
    @XmlElement(name = "ShippingServiceCost")
    private Double shippingServiceCost;

    /** Shipping service additional costs. */
    @XmlElement(name = "ShippingServiceAdditionalCost")
    private Double shippingServiceAdditionalCost;

    @XmlAttribute(name = "currencyID")
    private CurrencyCodeType currencyCodeType;

    /**
     * Sets new Shipping service code reference..
     *
     * @param shippingServiceCode
     *         New value of Shipping service code reference..
     */
    public void setShippingServiceCode(ShippingServiceCode shippingServiceCode) {
        this.shippingServiceCode = shippingServiceCode;
    }

    /**
     * Gets Shipping service cost..
     *
     * @return Value of Shipping service cost..
     */
    public Double getShippingServiceCost() {
        return shippingServiceCost;
    }

    /**
     * Sets new Shipping service cost..
     *
     * @param shippingServiceCost
     *         New value of Shipping service cost..
     */
    public void setShippingServiceCost(Double shippingServiceCost) {
        this.shippingServiceCost = shippingServiceCost;
    }

    /**
     * Gets Shipping service code reference..
     *
     * @return Value of Shipping service code reference..
     */
    public ShippingServiceCode getShippingServiceCode() {
        return shippingServiceCode;
    }

    /**
     * Sets new Shipping service additional costs..
     *
     * @param shippingServiceAdditionalCost
     *         New value of Shipping service additional costs..
     */
    public void setShippingServiceAdditionalCost(Double shippingServiceAdditionalCost) {
        this.shippingServiceAdditionalCost = shippingServiceAdditionalCost;
    }

    /**
     * Gets Shipping service additional costs..
     *
     * @return Value of Shipping service additional costs..
     */
    public Double getShippingServiceAdditionalCost() {
        return shippingServiceAdditionalCost;
    }

    /**
     * Gets currencyCodeType.
     *
     * @return Value of currencyCodeType.
     */
    public CurrencyCodeType getCurrencyCodeType() {
        return currencyCodeType;
    }

    /**
     * Sets new currencyCodeType.
     *
     * @param currencyCodeType
     *         New value of currencyCodeType.
     */
    public void setCurrencyCodeType(CurrencyCodeType currencyCodeType) {
        this.currencyCodeType = currencyCodeType;
    }
}
