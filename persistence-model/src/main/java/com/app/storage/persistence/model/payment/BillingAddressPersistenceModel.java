package com.app.storage.persistence.model.payment;

import com.app.storage.persistence.model.UserPersistenceModel;
import org.apache.commons.lang.builder.EqualsBuilder;

import javax.persistence.*;

/**
 * Billing Address persistence model.
 */
@Entity
@Table(name = "BillingAddress")
public class BillingAddressPersistenceModel {

    /** Unique db id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idBillingAddress")
    private Long id;

    /** Street Address Details. */
    @Column(name = "StreetAddress")
    private String streetAddress;

    /** Region. */
    @Column(name = "Region")
    private String region;

    /** Address postcode */
    @Column(name = "PostCode")
    private String postCode;

    /** Billing address country. */
    @Column(name = "Country")
    private String country;

    /**
     * Many-1 reference to owner model.
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserPersistenceModel userPersistenceModel;

    /**
     * Gets Billing address country..
     *
     * @return Value of Billing address country..
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets new Billing address country..
     *
     * @param country
     *         New value of Billing address country..
     */
    public void setCountry(String country) {
        this.country = country;
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
     * Gets Region..
     *
     * @return Value of Region..
     */
    public String getRegion() {
        return region;
    }

    /**
     * Gets Address postcode.
     *
     * @return Value of Address postcode.
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets new Address postcode.
     *
     * @param postCode
     *         New value of Address postcode.
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * Gets Street Address Details..
     *
     * @return Value of Street Address Details..
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets new Street Address Details..
     *
     * @param streetAddress
     *         New value of Street Address Details..
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Gets Many-1 reference to owner model..
     *
     * @return Value of Many-1 reference to owner model..
     */
    public UserPersistenceModel getUserPersistenceModel() {
        return userPersistenceModel;
    }

    /**
     * Sets new Many-1 reference to owner model..
     *
     * @param userPersistenceModel
     *         New value of Many-1 reference to owner model..
     */
    public void setUserPersistenceModel(UserPersistenceModel userPersistenceModel) {
        this.userPersistenceModel = userPersistenceModel;
    }

    /**
     * Gets Unique db id..
     *
     * @return Value of Unique db id..
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets new Unique db id..
     *
     * @param id
     *         New value of Unique db id..
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof BillingAddressPersistenceModel))
            return false;
        if (obj == this)
            return true;

        BillingAddressPersistenceModel billingAddressPersistenceModel = (BillingAddressPersistenceModel) obj;
        return new EqualsBuilder()
                .append(getStreetAddress(), billingAddressPersistenceModel.getStreetAddress())
                .append(getCountry(), billingAddressPersistenceModel.getCountry())
                .append(getPostCode(), billingAddressPersistenceModel.getPostCode())
                .append(getRegion(), billingAddressPersistenceModel.getRegion())
                .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(id).append(streetAddress).append(region).append(postCode).append(country);

        return stringBuilder.toString();
    }
}
