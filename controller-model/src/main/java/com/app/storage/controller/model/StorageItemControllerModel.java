package com.app.storage.controller.model;

import com.app.storage.domain.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Storage item controller model.
 */
public class StorageItemControllerModel {

    /** Reference identifier. */
    @JsonProperty("id")
    private Long id;

    /** Item size. */
    @JsonProperty("Size")
    private String size;

    /** Description. */
    @JsonProperty("Description")
    private String description;

    /** Brand. */
    @JsonProperty("Brand")
    private String brand;

    /** Grade. */
    @JsonProperty("Grade")
    private String grade;

    /** Image taken of item. */
    @JsonProperty("Image")
    private byte[] image;

    /** Url image. */
    private String imageUrl;

    /** Owner. */
    private User user;


    /**
     * Gets Image taken of item..
     *
     * @return Value of Image taken of item..
     */
    public byte[] getImage() {
        return image;
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
     * Gets Brand..
     *
     * @return Value of Brand..
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets Grade..
     *
     * @return Value of Grade..
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Gets Description..
     *
     * @return Value of Description..
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets new Brand..
     *
     * @param brand
     *         New value of Brand..
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Sets new Description..
     *
     * @param description
     *         New value of Description..
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets new Grade..
     *
     * @param grade
     *         New value of Grade..
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Gets Owner..
     *
     * @return Value of Owner..
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets new Owner..
     *
     * @param user
     *         New value of Owner..
     */
    public void setUser(User user) {
        this.user = user;
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
        return new EqualsBuilder()
                .append(getId(), storageItemControllerModel.getId())
                .append(getSize(), storageItemControllerModel.getSize())
                .append(getImage(), storageItemControllerModel.getImage())
                .append(getBrand(), storageItemControllerModel.getBrand())
                .append(getDescription(), storageItemControllerModel.getDescription())
                .append(getGrade(), storageItemControllerModel.getGrade())
                .append(getUser(), storageItemControllerModel.getUser())
                .isEquals();
    }

    /**
     * To string builder.
     *
     * @return Object as string.
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(id).append(size).append(brand).append(description).append(grade);

        return stringBuilder.toString();
    }
}
