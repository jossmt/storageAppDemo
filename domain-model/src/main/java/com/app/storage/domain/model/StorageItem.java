package com.app.storage.domain.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.joda.time.DateTime;

/**
 * Storage item.
 */
public class StorageItem {

    /** Reference identifier. */
    private Long id;

    /** Date item was stored. */
    private DateTime dateStored;

    /** Name of item. */
    private String name;

    /** Item size. */
    private String size;

    /** Image taken of item. */
    private byte[] image;

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
    public String getName() {
        return name;
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
    public DateTime getDateStored() {
        return dateStored;
    }

    /**
     * Gets Reference identifier..
     *
     * @return Value of Reference identifier..
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets new Name of item..
     *
     * @param name
     *         New value of Name of item..
     */
    public void setName(String name) {
        this.name = name;
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
     * Sets new Reference identifier..
     *
     * @param id
     *         New value of Reference identifier..
     */
    public void setId(Long id) {
        this.id = id;
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
    public void setDateStored(DateTime dateStored) {
        this.dateStored = dateStored;
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
                .append(getDateStored(), storageItem.getDateStored())
                .append(getId(), storageItem.getId())
                .append(getName(), storageItem.getName())
                .append(getSize(), storageItem.getSize())
                .append(getImage(), storageItem.getImage())
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

        stringBuilder.append(id).append(name).append(size).append(dateStored).append(image);

        return stringBuilder.toString();
    }
}
