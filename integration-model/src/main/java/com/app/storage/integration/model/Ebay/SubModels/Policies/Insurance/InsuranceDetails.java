package com.app.storage.integration.model.Ebay.SubModels.Policies.Insurance;

import com.app.storage.integration.model.Ebay.SubModels.ListingDetails.CurrencyCodeType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Covers Insurance Requirements for Item.
 */
public class InsuranceDetails {

    /**
     * Fee for insurance
     */
    @XmlElement(name = "InsuranceFee")
    private Double insuranceFee;

    /**
     * Insurance type.
     */
    @XmlElement(name = "InsuranceOption")
    private InsuranceOption insuranceOption;

    /**
     * Currency of insurance charge.
     */
    @XmlAttribute(name = "CurrencyID")
    private CurrencyCodeType currencyCodeType;


    /**
     * Sets new Currency of insurance charge..
     *
     * @param currencyCodeType
     *         New value of Currency of insurance charge..
     */
    public void setCurrencyCodeType(CurrencyCodeType currencyCodeType) {
        this.currencyCodeType = currencyCodeType;
    }

    /**
     * Gets Fee for insurance.
     *
     * @return Value of Fee for insurance.
     */
    public Double getInsuranceFee() {
        return insuranceFee;
    }

    /**
     * Gets Currency of insurance charge..
     *
     * @return Value of Currency of insurance charge..
     */
    public CurrencyCodeType getCurrencyCodeType() {
        return currencyCodeType;
    }

    /**
     * Sets new Fee for insurance.
     *
     * @param insuranceFee
     *         New value of Fee for insurance.
     */
    public void setInsuranceFee(Double insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    /**
     * Sets new Insurance type..
     *
     * @param insuranceOption
     *         New value of Insurance type..
     */
    public void setInsuranceOption(InsuranceOption insuranceOption) {
        this.insuranceOption = insuranceOption;
    }

    /**
     * Gets Insurance type..
     *
     * @return Value of Insurance type..
     */
    public InsuranceOption getInsuranceOption() {
        return insuranceOption;
    }
}
