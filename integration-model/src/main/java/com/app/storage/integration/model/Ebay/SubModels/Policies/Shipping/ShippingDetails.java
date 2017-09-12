package com.app.storage.integration.model.Ebay.SubModels.Policies.Shipping;

import com.app.storage.integration.model.Ebay.SubModels.ListingDetails.CurrencyCodeType;
import com.app.storage.integration.model.Ebay.SubModels.Policies.Insurance.InsuranceDetailsModel;
import com.app.storage.integration.model.Ebay.SubModels.Policies.Insurance.InternationalInsuranceDetailsModel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ShippingDetails")
public class ShippingDetails {

    /** Cash on delivery cost if cash on delivery is payment preference. */
    @XmlElement(name = "CODCost")
    private Double CODCost;

    /** Currency of shipping costs. */
    @XmlAttribute(name = "CurrencyID")
    private CurrencyCodeType currencyCodeType;

    /** Locations shipping excludes. */
    @XmlElement(name = "ExcludeToLocation")
    private String excludeToLocation;

    /** Assert whether Ebay Global Shipping Programme. */
    @XmlElement(name = "GlobalShipping")
    private boolean globalShipping;

    /** Insurance detail requirements. */
    @XmlElement(name = "InsuranceDetails")
    private InsuranceDetailsModel insuranceDetails;

    /** International insurance detail requirements. */
    @XmlElement(name = "InternationalInsuranceDetails")
    private InternationalInsuranceDetailsModel internationalInsuranceDetails;

    /** List of shipping service options. */
    @XmlElement(name = "ShippingServiceOption")
    private List<ShippingServiceOptionModel> shippingServiceOptionModels;

    /** List of international shipping service options. */
    @XmlElement(name = "InternationalShippingServiceOption")
    private List<InternationalShippingServiceOptionModel> internationalShippingServiceOptionModels;


    /**
     * Gets Cash on delivery cost if cash on delivery is payment preference..
     *
     * @return Value of Cash on delivery cost if cash on delivery is payment preference..
     */
    public Double getCODCost() {
        return CODCost;
    }

    /**
     * Sets new List of international shipping service options..
     *
     * @param internationalShippingServiceOptionModels
     *         New value of List of international shipping service options..
     */
    public void setInternationalShippingServiceOptionModels(List<InternationalShippingServiceOptionModel>
                                                                    internationalShippingServiceOptionModels) {
        this.internationalShippingServiceOptionModels = internationalShippingServiceOptionModels;
    }

    /**
     * Sets new Cash on delivery cost if cash on delivery is payment preference..
     *
     * @param CODCost
     *         New value of Cash on delivery cost if cash on delivery is payment preference..
     */
    public void setCODCost(Double CODCost) {
        this.CODCost = CODCost;
    }

    /**
     * Gets International insurance detail requirements..
     *
     * @return Value of International insurance detail requirements..
     */
    public InternationalInsuranceDetailsModel getInternationalInsuranceDetails() {
        return internationalInsuranceDetails;
    }

    /**
     * Sets new International insurance detail requirements..
     *
     * @param internationalInsuranceDetails
     *         New value of International insurance detail requirements..
     */
    public void setInternationalInsuranceDetails(InternationalInsuranceDetailsModel internationalInsuranceDetails) {
        this.internationalInsuranceDetails = internationalInsuranceDetails;
    }

    /**
     * Sets new List of shipping service options..
     *
     * @param shippingServiceOptionModels
     *         New value of List of shipping service options..
     */
    public void setShippingServiceOptionModels(List<ShippingServiceOptionModel> shippingServiceOptionModels) {
        this.shippingServiceOptionModels = shippingServiceOptionModels;
    }

    /**
     * Gets Currency of shipping costs..
     *
     * @return Value of Currency of shipping costs..
     */
    public CurrencyCodeType getCurrencyCodeType() {
        return currencyCodeType;
    }

    /**
     * Gets Assert whether Ebay Global Shipping Programme..
     *
     * @return Value of Assert whether Ebay Global Shipping Programme..
     */
    public boolean isGlobalShipping() {
        return globalShipping;
    }

    /**
     * Gets List of international shipping service options..
     *
     * @return Value of List of international shipping service options..
     */
    public List<InternationalShippingServiceOptionModel> getInternationalShippingServiceOptionModels() {
        return internationalShippingServiceOptionModels;
    }

    /**
     * Gets Insurance detail requirements..
     *
     * @return Value of Insurance detail requirements..
     */
    public InsuranceDetailsModel getInsuranceDetails() {
        return insuranceDetails;
    }

    /**
     * Sets new Locations shipping excludes..
     *
     * @param excludeToLocation
     *         New value of Locations shipping excludes..
     */
    public void setExcludeToLocation(String excludeToLocation) {
        this.excludeToLocation = excludeToLocation;
    }

    /**
     * Gets Locations shipping excludes..
     *
     * @return Value of Locations shipping excludes..
     */
    public String getExcludeToLocation() {
        return excludeToLocation;
    }

    /**
     * Sets new Insurance detail requirements..
     *
     * @param insuranceDetails
     *         New value of Insurance detail requirements..
     */
    public void setInsuranceDetails(InsuranceDetailsModel insuranceDetails) {
        this.insuranceDetails = insuranceDetails;
    }

    /**
     * Sets new Currency of shipping costs..
     *
     * @param currencyCodeType
     *         New value of Currency of shipping costs..
     */
    public void setCurrencyCodeType(CurrencyCodeType currencyCodeType) {
        this.currencyCodeType = currencyCodeType;
    }

    /**
     * Gets List of shipping service options..
     *
     * @return Value of List of shipping service options..
     */
    public List<ShippingServiceOptionModel> getShippingServiceOptionModels() {
        return shippingServiceOptionModels;
    }

    /**
     * Sets new Assert whether Ebay Global Shipping Programme..
     *
     * @param globalShipping
     *         New value of Assert whether Ebay Global Shipping Programme..
     */
    public void setGlobalShipping(boolean globalShipping) {
        this.globalShipping = globalShipping;
    }
}
