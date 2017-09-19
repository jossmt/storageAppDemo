package com.app.storage.integration.model.Ebay.Responses;

import com.app.storage.integration.model.Ebay.SubModels.General.Error.GenericErrorsWrapper;
import org.joda.time.DateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Ebay generic system error response model.
 */
@XmlRootElement(name = "eBay")
public class EbayGenericErrorResponseIntegrationModel implements Serializable{

    /** Ebay date time of error. */
    @XmlElement(name = "EbayTime")
    private DateTime ebayDateTime;

    /** Generic errors wrapper. */
    @XmlElement(name = "Errors")
    private GenericErrorsWrapper errorList;
}
