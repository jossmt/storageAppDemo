package com.app.storage.integration.model.Ebay.SubModels.ItemDetails;

import javax.xml.bind.annotation.XmlElement;

/**
 * Category abstract reference.
 */
public class Category {

    /** id of category. */
    @XmlElement(name = "CategoryID")
    private String categoryID;


    /**
     * Sets new id of category..
     *
     * @param categoryID
     *         New value of id of category..
     */
    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * Gets id of category..
     *
     * @return Value of id of category..
     */
    public String getCategoryID() {
        return categoryID;
    }
}
