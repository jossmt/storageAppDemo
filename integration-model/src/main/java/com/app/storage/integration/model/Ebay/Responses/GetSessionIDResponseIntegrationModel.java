package com.app.storage.integration.model.Ebay.Responses;

import com.app.storage.integration.model.Ebay.SubModels.General.Other.AckCodeType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.joda.time.DateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Returns SessionID following GetSessionIDRequest
 */
@XmlRootElement(name = "GetSessionIDResponse", namespace = "urn:ebay:apis:eBLBaseComponents")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetSessionIDResponseIntegrationModel implements Serializable {

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

    /** Session id. */
    @XmlElement(name = "SessionID")
    private String sessionID;


    /**
     * Gets Session id..
     *
     * @return Value of Session id..
     */
    public String getSessionID() {
        return sessionID;
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
     * Sets new Specific ebay build used to process request..
     *
     * @param build
     *         New value of Specific ebay build used to process request..
     */
    public void setBuild(String build) {
        this.build = build;
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
     * Gets Determines response status successfailure..
     *
     * @return Value of Determines response status successfailure..
     */
    public AckCodeType getAckCodeType() {
        return ackCodeType;
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
     * Gets Refers to MessageID passed in Request..
     *
     * @return Value of Refers to MessageID passed in Request..
     */
    public String getCorrelationID() {
        return correlationID;
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
     * Sets new Timestamp of response..
     *
     * @param timeStamp
     *         New value of Timestamp of response..
     */
    public void setTimeStamp(DateTime timeStamp) {
        this.timeStamp = timeStamp;
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
     * Sets new Session id..
     *
     * @param sessionID
     *         New value of Session id..
     */
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
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
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof GetSessionIDResponseIntegrationModel))
            return false;
        if (obj == this)
            return true;

        GetSessionIDResponseIntegrationModel getSessionIDResponseIntegrationModel =
                (GetSessionIDResponseIntegrationModel) obj;
        return new EqualsBuilder()
                .append(getSessionID(), getSessionIDResponseIntegrationModel.getSessionID())
                .append(getErrorList(), getSessionIDResponseIntegrationModel.getErrorList())
                .append(getAckCodeType(), getSessionIDResponseIntegrationModel.getAckCodeType())
                .append(getBuild(), getSessionIDResponseIntegrationModel.getBuild())
                .append(getCorrelationID(), getSessionIDResponseIntegrationModel.getCorrelationID())
                .append(getTimeStamp(), getSessionIDResponseIntegrationModel.getTimeStamp())
                .append(getVersion(), getSessionIDResponseIntegrationModel.getVersion())
                .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(sessionID).append(errorList).append(ackCodeType).append(build).append(correlationID)
                .append(timeStamp).append(version);

        return stringBuilder.toString();
    }
}
