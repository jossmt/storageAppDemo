package com.app.storage.integration.model.Ebay.SubModels.General.Error;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Error parameters attached to {@link Error}
 */
@XmlRootElement(name = "ErrorParameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorParameters {

    /** Value of error param. */
    @XmlElement(name = "Value")
    private String value;


    /**
     * Sets new Value of error param..
     *
     * @param value
     *         New value of Value of error param..
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets Value of error param..
     *
     * @return Value of Value of error param..
     */
    public String getValue() {
        return value;
    }
}
