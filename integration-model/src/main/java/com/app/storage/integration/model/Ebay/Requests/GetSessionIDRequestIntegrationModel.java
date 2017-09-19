package com.app.storage.integration.model.Ebay.Requests;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Model for GetSessionIdRequest
 */
@XmlRootElement(name = "GetSessionIDRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetSessionIDRequestIntegrationModel implements Serializable{

    @XmlElement(name = "RuName")
    private String ruName;

    /**
     * Sets new ruName.
     *
     * @param ruName
     *         New value of ruName.
     */
    public void setRuName(String ruName) {
        this.ruName = ruName;
    }

    /**
     * Gets ruName.
     *
     * @return Value of ruName.
     */
    public String getRuName() {
        return ruName;
    }
}
