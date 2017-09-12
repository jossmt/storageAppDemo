package com.app.storage.integration.model.Ebay.SubModels.Policies.Shipping;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * International shipping service option data.
 */
@XmlRootElement(name = "InternationalShippingServiceOption")
public class InternationalShippingServiceOptionModel extends ShippingServiceOption {

    /** Locations enabled for shipping. */
    @XmlElement(name = "ShipToLocation")
    private List<String> shipToLocations;


    /**
     * Gets Locations enabled for shipping..
     *
     * @return Value of Locations enabled for shipping..
     */
    public List<String> getShipToLocations() {
        return shipToLocations;
    }

    /**
     * Sets new Locations enabled for shipping..
     *
     * @param shipToLocations
     *         New value of Locations enabled for shipping..
     */
    public void setShipToLocations(List<String> shipToLocations) {
        this.shipToLocations = shipToLocations;
    }
}
