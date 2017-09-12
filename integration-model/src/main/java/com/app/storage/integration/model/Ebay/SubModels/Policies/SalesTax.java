package com.app.storage.integration.model.Ebay.SubModels.Policies;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Sales tax.
 */
@XmlRootElement(name = "SalesTax")
public class SalesTax {

    /** Sales tax percent. */
    @XmlElement(name = "SalesTaxPercent")
    private float salesTaxPercent;

    /** Shipping included in tax. */
    @XmlElement(name = "ShippingIncludedInTax")
    private boolean shippingIncludedInTax;

    /**
     * Sets new Shipping included in tax..
     *
     * @param shippingIncludedInTax
     *         New value of Shipping included in tax..
     */
    public void setShippingIncludedInTax(boolean shippingIncludedInTax) {
        this.shippingIncludedInTax = shippingIncludedInTax;
    }

    /**
     * Gets Sales tax percent..
     *
     * @return Value of Sales tax percent..
     */
    public float getSalesTaxPercent() {
        return salesTaxPercent;
    }

    /**
     * Sets new Sales tax percent..
     *
     * @param salesTaxPercent
     *         New value of Sales tax percent..
     */
    public void setSalesTaxPercent(float salesTaxPercent) {
        this.salesTaxPercent = salesTaxPercent;
    }

    /**
     * Gets Shipping included in tax..
     *
     * @return Value of Shipping included in tax..
     */
    public boolean isShippingIncludedInTax() {
        return shippingIncludedInTax;
    }
}
