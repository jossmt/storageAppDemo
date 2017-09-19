package com.app.storage.integration.model.Ebay.Responses;

import com.app.storage.integration.model.Ebay.SubModels.General.Error.GenericErrorsWrapper;
import org.joda.time.DateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Ebay generic system error response model.
 */
@XmlRootElement(name = "eBay", namespace = "urn:ebay:apis:eBLBaseComponents")
public class EbayApplicationLevelErrorResponseModel implements Serializable {

    /** Ebay date time of error. */
    @XmlElement(name = "EbayTime")
    private DateTime ebayDateTime;

    /** Generic errors wrapper. */
    @XmlElement(name = "Errors")
    private GenericErrorsWrapper errorList;


    /**
     * Sets new Ebay date time of error..
     *
     * @param ebayDateTime
     *         New value of Ebay date time of error..
     */
    public void setEbayDateTime(DateTime ebayDateTime) {
        this.ebayDateTime = ebayDateTime;
    }

    /**
     * Gets Ebay date time of error..
     *
     * @return Value of Ebay date time of error..
     */
    public DateTime getEbayDateTime() {
        return ebayDateTime;
    }

    /**
     * Sets new Generic errors wrapper..
     *
     * @param errorList
     *         New value of Generic errors wrapper..
     */
    public void setErrorList(GenericErrorsWrapper errorList) {
        this.errorList = errorList;
    }

    /**
     * Gets Generic errors wrapper..
     *
     * @return Value of Generic errors wrapper..
     */
    public GenericErrorsWrapper getErrorList() {
        return errorList;
    }
}
