package com.app.storage.integration.model.Ebay.SubModels.Policies.Shipping;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Shipping service option data.
 */
@XmlRootElement(name = "ShippingServiceOptions")
public class ShippingServiceOptionModel extends ShippingServiceOption {

    /** Free shipping enabler. */
    @XmlElement(name = "FreeShipping")
    private boolean freeShipping;

    /** Shipping surcharge. */
    @XmlElement(name = "ShippingSurcharge")
    private Double shippingSurcharge;

    /**
     * Gets Shipping surcharge..
     *
     * @return Value of Shipping surcharge..
     */
    public Double getShippingSurcharge() {
        return shippingSurcharge;
    }

    /**
     * Sets new Shipping surcharge..
     *
     * @param shippingSurcharge
     *         New value of Shipping surcharge..
     */
    public void setShippingSurcharge(Double shippingSurcharge) {
        this.shippingSurcharge = shippingSurcharge;
    }

    /**
     * Gets Free shipping enabler..
     *
     * @return Value of Free shipping enabler..
     */
    public boolean isFreeShipping() {
        return freeShipping;
    }

    /**
     * Sets new Free shipping enabler..
     *
     * @param freeShipping
     *         New value of Free shipping enabler..
     */
    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }
}
