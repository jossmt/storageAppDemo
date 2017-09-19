package com.app.storage.integration.model.Ebay.Responses;

import com.app.storage.integration.model.Ebay.SubModels.General.Other.AckCodeType;
import org.joda.time.DateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Fetch token response from ebay api.
 */
@XmlRootElement(name = "FetchTokenResponse", namespace = "urn:ebay:apis:eBLBaseComponents")
@XmlAccessorType(XmlAccessType.FIELD)
public class FetchTokenResponseIntegrationModel {

    /** Ebay authorisation token. */
    @XmlElement(name = "eBayAuthToken")
    private String ebayAuthToken;

    /** Expiration time of auth token. */
    @XmlElement(name = "HardExpirationTime")
    private DateTime hardExpirationTime;

    /** REST Token. */
    @XmlElement(name = "RESTToken")
    private String restToken;

    /** Determines response status (success/failure). */
    @XmlElement(name = "Ack")
    private AckCodeType ackCodeType;

    @XmlElement(name = "Errors")
    private List<Error> errorList;

    /** Specific ebay build used to process request. */
    @XmlElement(name = "Build")
    private String build;

    /** Refers to MessageID passed in Request. */
    @XmlElement(name = "CorrelationID")
    private String correlationID;

    /** Timestamp of response. */
    @XmlElement(name = "TimeStamp")
    private DateTime timeStamp;

    /** Version of response schema used. */
    @XmlElement(name = "Version")
    private String version;

    /**
     * Sets new errorList.
     *
     * @param errorList
     *         New value of errorList.
     */
    public void setErrorList(List<Error> errorList) {
        this.errorList = errorList;
    }

    /**
     * Gets errorList.
     *
     * @return Value of errorList.
     */
    public List<Error> getErrorList() {
        return errorList;
    }

    /**
     * Gets Timestamp of response..
     *
     * @return Value of Timestamp of response..
     */
    public DateTime getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets new Version of response schema used..
     *
     * @param version
     *         New value of Version of response schema used..
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Sets new Specific ebay build used to process request..
     *
     * @param build
     *         New value of Specific ebay build used to process request..
     */
    public void setBuild(String build) {
        this.build = build;
    }

    /**
     * Sets new Determines response status successfailure..
     *
     * @param ackCodeType
     *         New value of Determines response status successfailure..
     */
    public void setAckCodeType(AckCodeType ackCodeType) {
        this.ackCodeType = ackCodeType;
    }

    /**
     * Gets Determines response status successfailure..
     *
     * @return Value of Determines response status successfailure..
     */
    public AckCodeType getAckCodeType() {
        return ackCodeType;
    }

    /**
     * Gets Version of response schema used..
     *
     * @return Value of Version of response schema used..
     */
    public String getVersion() {
        return version;
    }

    /**
     * Gets Specific ebay build used to process request..
     *
     * @return Value of Specific ebay build used to process request..
     */
    public String getBuild() {
        return build;
    }

    /**
     * Gets Refers to MessageID passed in Request..
     *
     * @return Value of Refers to MessageID passed in Request..
     */
    public String getCorrelationID() {
        return correlationID;
    }

    /**
     * Sets new Refers to MessageID passed in Request..
     *
     * @param correlationID
     *         New value of Refers to MessageID passed in Request..
     */
    public void setCorrelationID(String correlationID) {
        this.correlationID = correlationID;
    }

    /**
     * Sets new Timestamp of response..
     *
     * @param timeStamp
     *         New value of Timestamp of response..
     */
    public void setTimeStamp(DateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Sets new Expiration time of auth token..
     *
     * @param hardExpirationTime
     *         New value of Expiration time of auth token..
     */
    public void setHardExpirationTime(DateTime hardExpirationTime) {
        this.hardExpirationTime = hardExpirationTime;
    }

    /**
     * Gets Ebay authorisation token..
     *
     * @return Value of Ebay authorisation token..
     */
    public String getEbayAuthToken() {
        return ebayAuthToken;
    }

    /**
     * Sets new REST Token..
     *
     * @param restToken
     *         New value of REST Token..
     */
    public void setRestToken(String restToken) {
        this.restToken = restToken;
    }

    /**
     * Sets new Ebay authorisation token..
     *
     * @param ebayAuthToken
     *         New value of Ebay authorisation token..
     */
    public void setEbayAuthToken(String ebayAuthToken) {
        this.ebayAuthToken = ebayAuthToken;
    }

    /**
     * Gets Expiration time of auth token..
     *
     * @return Value of Expiration time of auth token..
     */
    public DateTime getHardExpirationTime() {
        return hardExpirationTime;
    }

    /**
     * Gets REST Token..
     *
     * @return Value of REST Token..
     */
    public String getRestToken() {
        return restToken;
    }
}
