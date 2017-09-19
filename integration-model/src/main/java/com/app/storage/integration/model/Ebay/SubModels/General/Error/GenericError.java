package com.app.storage.integration.model.Ebay.SubModels.General.Error;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Error returned from invalid requests.
 */
@XmlRootElement(name = "Error")
@XmlAccessorType(XmlAccessType.FIELD)
public class GenericError {

    /** Error parameters. */
    @XmlElement(name = "ErrorParameters")
    private List<ErrorParameters> errorParameters;

    /** Long message. */
    @XmlElement(name = "LongMessage")
    private String longMessage;

    /** Short message. */
    @XmlElement(name = "ShortMessage")
    private String shortMessage;

    /** Severity code of error. */
    @XmlElement(name = "SeverityCode")
    private SeverityCodeType severityCode;

    /** Error classification. */
    @XmlElement(name = "ErrorClassification")
    private ErrorClassificationCodeType errorClassification;

    /** Error code specifically referencing custom code. */
    @XmlElement(name = "ErrorCode")
    private Long errorCode;


    /**
     * Sets new Severity code of error..
     *
     * @param severityCode
     *         New value of Severity code of error..
     */
    public void setSeverityCode(SeverityCodeType severityCode) {
        this.severityCode = severityCode;
    }

    /**
     * Sets new Error classification..
     *
     * @param errorClassification
     *         New value of Error classification..
     */
    public void setErrorClassification(ErrorClassificationCodeType errorClassification) {
        this.errorClassification = errorClassification;
    }

    /**
     * Sets new Long message..
     *
     * @param longMessage
     *         New value of Long message..
     */
    public void setLongMessage(String longMessage) {
        this.longMessage = longMessage;
    }

    /**
     * Sets new Error parameters..
     *
     * @param errorParameters
     *         New value of Error parameters..
     */
    public void setErrorParameters(List<ErrorParameters> errorParameters) {
        this.errorParameters = errorParameters;
    }

    /**
     * Gets Long message..
     *
     * @return Value of Long message..
     */
    public String getLongMessage() {
        return longMessage;
    }

    /**
     * Gets Error code specifically referencing custom code..
     *
     * @return Value of Error code specifically referencing custom code..
     */
    public Long getErrorCode() {
        return errorCode;
    }

    /**
     * Sets new Error code specifically referencing custom code..
     *
     * @param errorCode
     *         New value of Error code specifically referencing custom code..
     */
    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets Short message..
     *
     * @return Value of Short message..
     */
    public String getShortMessage() {
        return shortMessage;
    }

    /**
     * Gets Error classification..
     *
     * @return Value of Error classification..
     */
    public ErrorClassificationCodeType getErrorClassification() {
        return errorClassification;
    }

    /**
     * Gets Error parameters..
     *
     * @return Value of Error parameters..
     */
    public List<ErrorParameters> getErrorParameters() {
        return errorParameters;
    }

    /**
     * Sets new Short message..
     *
     * @param shortMessage
     *         New value of Short message..
     */
    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    /**
     * Gets Severity code of error..
     *
     * @return Value of Severity code of error..
     */
    public SeverityCodeType getSeverityCode() {
        return severityCode;
    }
}
