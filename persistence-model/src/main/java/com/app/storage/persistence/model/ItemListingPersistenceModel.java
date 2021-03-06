package com.app.storage.persistence.model;

import org.apache.commons.lang.builder.EqualsBuilder;

import javax.persistence.*;
import java.util.Date;


/**
 * Users photo storage persistence model.
 */
@Entity
@Table(name = "ItemListing")
public class ItemListingPersistenceModel {

    /** Reference identifier. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /** Unique reference id. */
    @Column(name = "Reference")
    private String reference;

    /** Date item was stored. */
    @Column(name = "DateStored")
    private Date dateStored;

    /** Name of item. */
    @Column(name = "Description")
    private String description;

    /** Grade of item. */
    @Column(name = "Grade")
    private String grade;

    /** Brand of item. */
    @Column(name = "Brand")
    private String brand;

    /** Item size. */
    @Column(name = "Size")
    private String size;

    /** Price. */
    @Column(name = "Price")
    private Double price;

    /** Image taken of item. */
    @Column(name = "Image")
    private byte[] image;

    /** Delivery charge. */
    @Column(name = "DeliveryCharge")
    private Double deliveryCharge;

    /** Delivery type. */
    @Column(name = "DeliveryType")
    private String deliveryType;

    /** Owner foreign key reference. */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserPersistenceModel userPersistenceModel;

    /**
     * Gets Reference identifier..
     *
     * @return Value of Reference identifier..
     */
    public long getId() {
        return id;
    }

    /**
     * Sets new Reference identifier..
     *
     * @param id
     *         New value of Reference identifier..
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets Image taken of item..
     *
     * @return Value of Image taken of item..
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * Gets Name of item..
     *
     * @return Value of Name of item..
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets Date item was stored..
     *
     * @return Value of Date item was stored..
     */
    public Date getDateStored() {
        return dateStored;
    }

    /**
     * Sets new Item size..
     *
     * @param size
     *         New value of Item size..
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Sets new Date item was stored..
     *
     * @param dateStored
     *         New value of Date item was stored..
     */
    public void setDateStored(Date dateStored) {
        this.dateStored = dateStored;
    }

    /**
     * Gets Item size..
     *
     * @return Value of Item size..
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets new Image taken of item..
     *
     * @param image
     *         New value of Image taken of item..
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * Sets new Name of item..
     *
     * @param description
     *         New value of Name of item..
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets Brand of item..
     *
     * @return Value of Brand of item..
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets new Brand of item..
     *
     * @param brand
     *         New value of Brand of item..
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets Grade of item..
     *
     * @return Value of Grade of item..
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets new Grade of item..
     *
     * @param grade
     *         New value of Grade of item..
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Gets userPersistenceModel.
     *
     * @return Value of userPersistenceModel.
     */
    public UserPersistenceModel getUserPersistenceModel() {
        return userPersistenceModel;
    }

    /**
     * Sets new userPersistenceModel.
     *
     * @param userPersistenceModel
     *         New value of userPersistenceModel.
     */
    public void setUserPersistenceModel(UserPersistenceModel userPersistenceModel) {
        this.userPersistenceModel = userPersistenceModel;
    }


    /**
     * Gets Price..
     *
     * @return Value of Price..
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets new Price..
     *
     * @param price
     *         New value of Price..
     */
    public void setPrice(final Double price) {
        this.price = price;
    }

    /**
     * Sets new Unique reference id..
     *
     * @param reference
     *         New value of Unique reference id..
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Gets Unique reference id..
     *
     * @return Value of Unique reference id..
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets new Delivery type..
     *
     * @param deliveryType
     *         New value of Delivery type..
     */
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    /**
     * Gets Delivery type..
     *
     * @return Value of Delivery type..
     */
    public String getDeliveryType() {
        return deliveryType;
    }

    /**
     * Sets new Delivery charge..
     *
     * @param deliveryCharge
     *         New value of Delivery charge..
     */
    public void setDeliveryCharge(Double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    /**
     * Gets Delivery charge..
     *
     * @return Value of Delivery charge..
     */
    public Double getDeliveryCharge() {
        return deliveryCharge;
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
        if (!(obj instanceof ItemListingPersistenceModel))
            return false;
        if (obj == this)
            return true;

        ItemListingPersistenceModel itemListing = (ItemListingPersistenceModel) obj;
        return new EqualsBuilder()
                .append(getDateStored(), itemListing.getDateStored())
                .append(getReference(), itemListing.getReference())
                .append(getDescription(), itemListing.getDescription())
                .append(getSize(), itemListing.getSize())
                .append(getImage(), itemListing.getImage())
                .append(getBrand(), itemListing.getBrand())
                .append(getGrade(), itemListing.getGrade())
                .append(getPrice(), itemListing.getPrice())
                .append(getDeliveryType(), itemListing.getDeliveryType())
                .append(getDeliveryCharge(), itemListing.getDeliveryCharge())
                .isEquals();
    }

    /**
     * To string.
     *
     * @return stringified object.
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(id).append(reference).append(description).append(size).append(dateStored)
                .append(brand).append(grade).append(price).append(deliveryType).append(deliveryCharge);

        return stringBuilder.toString();
    }
}
