package com.app.storage.domain.model;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.Date;

/**
 * Storage item.
 */
public class StorageItem {

    /** Unique reference code. */
    private String reference;

    /** Date item was stored. */
    private Date dateStored;

    /** Description of item. */
    private String description;

    /** Item size. */
    private String size;

    /** Brand of product. */
    private String brand;

    /** Quality of product. */
    private Grade grade;

    /** Price. */
    private Double price;

    /** Image taken of item. */
    private byte[] image;

    /** URl represenation of image. */
    private String imageUrl;

    /** Owner of item. */
    private User owner;

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
     * Gets Item size..
     *
     * @return Value of Item size..
     */
    public String getSize() {
        return size;
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
     * Sets new Name of item..
     *
     * @param description
     *         New value of Name of item..
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Gets Brand of product..
     *
     * @return Value of Brand of product..
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets new Brand of product..
     *
     * @param brand
     *         New value of Brand of product..
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Sets new Quality of product..
     *
     * @param grade
     *         New value of Quality of product..
     */
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    /**
     * Gets Quality of product..
     *
     * @return Value of Quality of product..
     */
    public Grade getGrade() {
        return grade;
    }

    /**
     * Gets Owner of item..
     *
     * @return Value of Owner of item..
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Sets new Owner of item..
     *
     * @param owner
     *         New value of Owner of item..
     */
    public void setOwner(final User owner) {
        this.owner = owner;
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
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Sets new URl represenation of image..
     *
     * @param imageUrl
     *         New value of URl represenation of image..
     */
    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Gets URl representation of image..
     *
     * @return Value of URl representation of image..
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Gets Unique reference code..
     *
     * @return Value of Unique reference code..
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets new Unique reference code..
     *
     * @param reference
     *         New value of Unique reference code..
     */
    public void setReference(final String reference) {
        this.reference = reference;
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
        if (!(obj instanceof StorageItem))
            return false;
        if (obj == this)
            return true;

        StorageItem storageItem = (StorageItem) obj;
        return new EqualsBuilder()
                .append(getReference(), storageItem.getReference())
                .append(getDateStored(), storageItem.getDateStored())
                .append(getDescription(), storageItem.getDescription())
                .append(getSize(), storageItem.getSize())
                .append(getImage(), storageItem.getImage())
                .append(getImageUrl(), storageItem.getImageUrl())
                .append(getBrand(), storageItem.getBrand())
                .append(getGrade(), storageItem.getGrade())
                .append(getOwner(), storageItem.getOwner())
                .append(getPrice(), storageItem.getPrice())
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

        stringBuilder.append(reference).append(description).append(size).append(dateStored).append(image).append
                (imageUrl)
                .append(brand).append(grade).append(owner).append(price);

        return stringBuilder.toString();
    }
}
