package com.app.storage.integration.model.Ebay.SubModels.General.Error;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Generic ebay system error {@link GenericError} wrapper
 */
@XmlRootElement(name = "Errors")
public class GenericErrorsWrapper {

    /***
     * List of generic errors.
     */
    @XmlElement(name = "Error")
    private List<GenericError> errorList;
}
