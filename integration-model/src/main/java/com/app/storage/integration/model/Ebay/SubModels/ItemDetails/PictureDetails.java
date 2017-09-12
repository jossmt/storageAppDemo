package com.app.storage.integration.model.Ebay.SubModels.ItemDetails;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Item listing picture details.
 */
@XmlRootElement(name = "PictureDetails")
@XmlAccessorType(XmlAccessType.FIELD)
public class PictureDetails {

    /** Url of picture. */
    @XmlElement(name = "PictureURL")
    private List<String> pictureUrl;

    /**
     * Gets Url of picture..
     *
     * @return Value of Url of picture..
     */
    public List<String> getPictureUrl() {
        return pictureUrl;
    }

    /**
     * Sets new Url of picture..
     *
     * @param pictureUrl
     *         New value of Url of picture..
     */
    public void setPictureUrl(List<String> pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
