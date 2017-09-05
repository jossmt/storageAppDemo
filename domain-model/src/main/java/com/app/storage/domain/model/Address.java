package com.app.storage.domain.model;

import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Billing Address Details.
 */
public class Address {

    /** Street Address. */
    private String streetAddress;

    /** Region. */
    private String region;

    /** Postcode. */
    private String postcode;

    /** Country name. */
    private String countryName;

    /** Address type. */
    private AddressType addressType;

    /** Boolean whether address is their default. */
    private boolean isDefault;

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
     * Gets Address type..
     *
     * @return Value of Address type..
     */
    public AddressType getAddressType() {
        return addressType;
    }

    /**
     * Sets new Address type..
     *
     * @param addressType
     *         New value of Address type..
     */
    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    /**
     * Sets new Boolean whether address is their default..
     *
     * @param isDefault
     *         New value of Boolean whether address is their default..
     */
    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * Gets Boolean whether address is their default..
     *
     * @return Value of Boolean whether address is their default..
     */
    public boolean isDefault() {
        return isDefault;
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
        if (!(obj instanceof Address))
            return false;
        if (obj == this)
            return true;

        Address address = (Address) obj;
        return new EqualsBuilder()
                .append(getCountryName(), address.getCountryName())
                .append(getStreetAddress(), address.getStreetAddress())
                .append(getPostcode(), address.getPostcode())
                .append(getRegion(), address.getRegion())
                .append(getAddressType(), address.getAddressType())
                .append(isDefault(), address.isDefault())
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

        stringBuilder.append(countryName).append(streetAddress).append(region).append(postcode).append(addressType)
                .append(isDefault);

        return stringBuilder.toString();
    }
}
