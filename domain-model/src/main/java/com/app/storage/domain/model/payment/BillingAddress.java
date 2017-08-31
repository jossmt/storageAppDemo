package com.app.storage.domain.model.payment;

import com.app.storage.domain.model.User;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Billing Address Details.
 */
public class BillingAddress {

    /** Street Address. */
    private String streetAddress;

    /** Region. */
    private String region;

    /** Postcode. */
    private String postcode;

    /** Country name. */
    private String countryName;

    /**
     * Sets new Country name..
     *
     * @param countryName
     *         New value of Country name..
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Gets Street Address..
     *
     * @return Value of Street Address..
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Gets Postcode..
     *
     * @return Value of Postcode..
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets new Street Address..
     *
     * @param streetAddress
     *         New value of Street Address..
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Gets Country name..
     *
     * @return Value of Country name..
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Gets Region..
     *
     * @return Value of Region..
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets new Postcode..
     *
     * @param postcode
     *         New value of Postcode..
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * Sets new Region..
     *
     * @param region
     *         New value of Region..
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Equals override.
     *
     * @param obj
     *         obj to compare.
     * @return equals boolean.
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof BillingAddress))
            return false;
        if (obj == this)
            return true;

        BillingAddress billingAddress = (BillingAddress) obj;
        return new EqualsBuilder()
                .append(getCountryName(), billingAddress.getCountryName())
                .append(getStreetAddress(), billingAddress.getStreetAddress())
                .append(getPostcode(), billingAddress.getPostcode())
                .append(getRegion(), billingAddress.getRegion())
                .isEquals();
    }

    /**
     * To String builder.
     *
     * @return String.
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(countryName).append(streetAddress).append(region).append(postcode);

        return stringBuilder.toString();
    }
}
