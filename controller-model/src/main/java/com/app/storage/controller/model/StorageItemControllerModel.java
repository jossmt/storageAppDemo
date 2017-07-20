package com.app.storage.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Storage item controller model.
 */
public class StorageItemControllerModel {

    /** Reference identifier. */
    @JsonProperty("id")
    private Long id;

    /** Name of item. */
    @JsonProperty("Name")
    private String name;

    /** Item size. */
    @JsonProperty("Size")
    private String size;

    /** Image taken of item. */
    @JsonProperty("Image")
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
     * Sets new Item size..
     *
     * @param size
     *         New value of Item size..
     */
    public void setSize(String size) {
        this.size = size;
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
     * @param name
     *         New value of Name of item..
     */
    public void setName(String name) {
        this.name = name;
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
     * Sets new Reference identifier..
     *
     * @param id
     *         New value of Reference identifier..
     */
    public void setId(Long id) {
        this.id = id;
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
        if (!(obj instanceof StorageItemControllerModel))
            return false;
        if (obj == this)
            return true;

        StorageItemControllerModel storageItemControllerModel = (StorageItemControllerModel) obj;
        return new EqualsBuilder().
                append(getId(), storageItemControllerModel.getId()).
                append(getName(), storageItemControllerModel.getName()).
                append(getSize(), storageItemControllerModel.getSize()).
                append(getImage(), storageItemControllerModel.getImage()).
                isEquals();
    }

    /**
     * To string builder.
     *
     * @return Object as string.
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(id).append(name).append(size);

        return stringBuilder.toString();
    }
}
