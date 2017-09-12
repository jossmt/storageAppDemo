package com.app.storage.integration.model.Ebay.SubModels.Policies;

import com.app.storage.integration.model.Ebay.SubModels.Policies.Warranty.WarrantyDurationOption;
import com.app.storage.integration.model.Ebay.SubModels.Policies.Warranty.WarrantyTypeOption;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Returns policy for item listing.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ReturnPolicy")
public class ReturnPolicy {

    /** Description of returns policy. */
    @XmlElement(name = "Description")
    private String description;

    /** Options include: MoneyBackOrExchange, MoneyBack, MoneyBackOrReplacement. */
    @XmlElement(name = "RefundOption")
    private String refundOption;

    /** ReturnsAcceptedOption or ReturnsNotAcceptedOption. */
    @XmlElement(name = "ReturnsAcceptedOption")
    private String returnsAcceptedOption;

    /** Either not set or WarrantyOffered */
    @XmlElement(name = "WarrantyOffered")
    private String warrantyOffered;

    /** Duration of warranty. */
    @XmlElement(name = "WarrantyDurationOption")
    private WarrantyDurationOption warrantyDurationOption;

    /** Type of warranty offered. */
    @XmlElement(name = "WarrantyTypeOption")
    private WarrantyTypeOption warrantyTypeOption;


    /**
     * Gets Duration of warranty..
     *
     * @return Value of Duration of warranty..
     */
    public WarrantyDurationOption getWarrantyDurationOption() {
        return warrantyDurationOption;
    }

    /**
     * Sets new Description of returns policy..
     *
     * @param description
     *         New value of Description of returns policy..
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets new ReturnsAcceptedOption or ReturnsNotAcceptedOption..
     *
     * @param returnsAcceptedOption
     *         New value of ReturnsAcceptedOption or ReturnsNotAcceptedOption..
     */
    public void setReturnsAcceptedOption(String returnsAcceptedOption) {
        this.returnsAcceptedOption = returnsAcceptedOption;
    }

    /**
     * Sets new Duration of warranty..
     *
     * @param warrantyDurationOption
     *         New value of Duration of warranty..
     */
    public void setWarrantyDurationOption(WarrantyDurationOption warrantyDurationOption) {
        this.warrantyDurationOption = warrantyDurationOption;
    }

    /**
     * Sets new Options include: MoneyBackOrExchange, MoneyBack, MoneyBackOrReplacement..
     *
     * @param refundOption
     *         New value of Options include: MoneyBackOrExchange, MoneyBack, MoneyBackOrReplacement..
     */
    public void setRefundOption(String refundOption) {
        this.refundOption = refundOption;
    }

    /**
     * Sets new Either not set or WarrantyOffered.
     *
     * @param warrantyOffered
     *         New value of Either not set or WarrantyOffered.
     */
    public void setWarrantyOffered(String warrantyOffered) {
        this.warrantyOffered = warrantyOffered;
    }

    /**
     * Gets ReturnsAcceptedOption or ReturnsNotAcceptedOption..
     *
     * @return Value of ReturnsAcceptedOption or ReturnsNotAcceptedOption..
     */
    public String getReturnsAcceptedOption() {
        return returnsAcceptedOption;
    }

    /**
     * Sets new Type of warranty offered..
     *
     * @param warrantyTypeOption
     *         New value of Type of warranty offered..
     */
    public void setWarrantyTypeOption(WarrantyTypeOption warrantyTypeOption) {
        this.warrantyTypeOption = warrantyTypeOption;
    }

    /**
     * Gets Description of returns policy..
     *
     * @return Value of Description of returns policy..
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets Options include: MoneyBackOrExchange, MoneyBack, MoneyBackOrReplacement..
     *
     * @return Value of Options include: MoneyBackOrExchange, MoneyBack, MoneyBackOrReplacement..
     */
    public String getRefundOption() {
        return refundOption;
    }

    /**
     * Gets Type of warranty offered..
     *
     * @return Value of Type of warranty offered..
     */
    public WarrantyTypeOption getWarrantyTypeOption() {
        return warrantyTypeOption;
    }

    /**
     * Gets Either not set or WarrantyOffered.
     *
     * @return Value of Either not set or WarrantyOffered.
     */
    public String getWarrantyOffered() {
        return warrantyOffered;
    }
}
