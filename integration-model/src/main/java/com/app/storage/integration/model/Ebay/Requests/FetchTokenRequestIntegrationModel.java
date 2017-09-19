package com.app.storage.integration.model.Ebay.Requests;

import com.app.storage.integration.model.Ebay.SubModels.General.Error.WarningLevelCodeType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Fetch token request integraiton model.
 */
@XmlRootElement(name = "FetchTokenRequest", namespace = "urn:ebay:apis:eBLBaseComponents")
@XmlAccessorType(XmlAccessType.FIELD)
public class FetchTokenRequestIntegrationModel {

    /** Secret identifier. */
    @XmlElement(name = "SecretID")
    private String secretId;

    /** Session identifier. */
    @XmlElement(name = "SessionID")
    private String sessionId;

    /** Error language. */
    @XmlElement(name = "ErrorLanguage")
    private String errorLanguage;

    /** Message identifier. */
    @XmlElement(name = "MessageID")
    private String messageId;

    /** Version. */
    @XmlElement(name = "Version")
    private String version;

    /** Warning level. */
    @XmlElement(name = "WarningLevel")
    private WarningLevelCodeType warningLevel;

    /**
     * Gets Message identifier..
     *
     * @return Value of Message identifier..
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets new Message identifier..
     *
     * @param messageId
     *         New value of Message identifier..
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * Gets Version..
     *
     * @return Value of Version..
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets new Warning level..
     *
     * @param warningLevel
     *         New value of Warning level..
     */
    public void setWarningLevel(WarningLevelCodeType warningLevel) {
        this.warningLevel = warningLevel;
    }

    /**
     * Sets new Version..
     *
     * @param version
     *         New value of Version..
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Gets Error language..
     *
     * @return Value of Error language..
     */
    public String getErrorLanguage() {
        return errorLanguage;
    }

    /**
     * Gets Session identifier..
     *
     * @return Value of Session identifier..
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Gets Secret identifier..
     *
     * @return Value of Secret identifier..
     */
    public String getSecretId() {
        return secretId;
    }

    /**
     * Sets new Secret identifier..
     *
     * @param secretId
     *         New value of Secret identifier..
     */
    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    /**
     * Sets new Session identifier..
     *
     * @param sessionId
     *         New value of Session identifier..
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * Gets Warning level..
     *
     * @return Value of Warning level..
     */
    public WarningLevelCodeType getWarningLevel() {
        return warningLevel;
    }

    /**
     * Sets new Error language..
     *
     * @param errorLanguage
     *         New value of Error language..
     */
    public void setErrorLanguage(String errorLanguage) {
        this.errorLanguage = errorLanguage;
    }
}
