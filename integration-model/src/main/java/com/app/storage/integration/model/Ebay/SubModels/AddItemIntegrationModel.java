package com.app.storage.integration.model.Ebay.SubModels;


import com.app.storage.integration.model.Ebay.SubModels.ItemDetails.PrimaryCategory;
import com.app.storage.integration.model.Ebay.SubModels.ItemDetails.SecondaryCategory;
import com.app.storage.integration.model.Ebay.SubModels.ListingDetails.*;
import com.app.storage.integration.model.Ebay.SubModels.Policies.PickupInStoreDetails;
import com.app.storage.integration.model.Ebay.SubModels.Policies.SalesTax;
import com.app.storage.integration.model.Ebay.SubModels.Policies.Shipping.ShippingDetails;
import com.app.storage.integration.model.Ebay.SubModels.Policies.Shipping.ShippingPackageDetails;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * AddItemRequest --> Item model
 */
@XmlRootElement(name = "Item")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddItemIntegrationModel {

    /** Item specific data (can store custom references). */
    @XmlElement(name = "ApplicationData")
    private String applicationData;

    /** Buy it now price. */
    @XmlElement(name = "BuyItNowPrice")
    private Double buyItNowPrice;

    /** Description of item condition. */
    @XmlElement(name = "ConditionDescription")
    private String conditionDescription;

    /** Ebay ID for condition (up to 1000). */
    @XmlElement(name = "ConditionID")
    private Integer conditionID;

    /** Details surrounding pricing of listing. */
    @XmlElement(name = "ListingDetails")
    private ListingDetails listingDetails;

    /** Country of item origin. */
    @XmlElement(name = "Country")
    private CountryCodeType country;

    /** Currency for item purchasing data. */
    @XmlElement(name = "Currency")
    private CurrencyCodeType currencyCodeType;

    /** Item description. */
    @XmlElement(name = "Description")
    private String description;

    /** Number of days before dispatch time after cleared payment (doesn't include shipping time) */
    @XmlElement(name = "DispatchTimeMax")
    private Integer dispatchTimeMax;

    /** Duration item to be listed. */
    @XmlElement(name = "ListingDuration")
    private ListingDuration listingDuration;

    /** Location of item. */
    @XmlElement(name = "Location")
    private String location;

    /** Accepted payment methods. */
    @XmlElement(name = "PaymentMethods")
    private List<PaymentMethodCodeType> buyerMethodCodeType;

    /** Email address of seller. */
    @XmlElement(name = "PaypalEmailAddress")
    private String paypalEmailAddress;

    /** Details for picking up in store. */
    @XmlElement(name = "PickupInStoreDetails")
    private PickupInStoreDetails pickupInStoreDetails;

    /** Postal code of item . */
    @XmlElement(name = "PostalCode")
    private String PostalCode;

    /** Primary category item fits into. */
    @XmlElement(name = "PrimaryCategory")
    private PrimaryCategory primaryCategory;

    /** Secondary category item fits into. */
    @XmlElement(name = "SecondaryCategory")
    private SecondaryCategory secondaryCategory;

    /** Quantity of item available. */
    @XmlElement(name = "Quantity")
    private Integer quantity;

    /** Price that bidding stops (once reserve is hit - item is sold). */
    @XmlElement(name = "ReservePrice")
    private Double reservePrice;

    /** Locationss item can be shipped to. */
    @XmlElement(name = "ShipToLocations")
    private String shipToLocations;

    /** Start price for bidding purposes. */
    @XmlElement(name = "StartPrice")
    private Double startPrice;

    /** Title of listing. */
    @XmlElement(name = "Title")
    private String title;

    /** Unique reference (again custom reference that can hold numori specific data). */
    @XmlElement(name = "UUID")
    private String UUID;

    /** Shipping details. */
    @XmlElement(name = "ShippingDetails")
    private ShippingDetails shippingDetails;

    /** Details of package item is shipped in. */
    @XmlElement(name = "ShippingPackageDetails")
    private ShippingPackageDetails shippingPackageDetails;

    /** Sales tax details. */
    @XmlElement(name = "SalesTax")
    private SalesTax salesTax;

    /**
     * Sets new Description of item condition..
     *
     * @param conditionDescription
     *         New value of Description of item condition..
     */
    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    /**
     * Gets Accepted payment methods..
     *
     * @return Value of Accepted payment methods..
     */
    public List<PaymentMethodCodeType> getBuyerMethodCodeType() {
        return buyerMethodCodeType;
    }

    /**
     * Gets Email address of seller..
     *
     * @return Value of Email address of seller..
     */
    public String getPaypalEmailAddress() {
        return paypalEmailAddress;
    }

    /**
     * Gets Buy it now price..
     *
     * @return Value of Buy it now price..
     */
    public Double getBuyItNowPrice() {
        return buyItNowPrice;
    }

    /**
     * Sets new Buy it now price..
     *
     * @param buyItNowPrice
     *         New value of Buy it now price..
     */
    public void setBuyItNowPrice(Double buyItNowPrice) {
        this.buyItNowPrice = buyItNowPrice;
    }

    /**
     * Sets new Number of days before dispatch time after cleared payment doesn't include shipping time.
     *
     * @param dispatchTimeMax
     *         New value of Number of days before dispatch time after cleared payment doesn't include shipping time.
     */
    public void setDispatchTimeMax(Integer dispatchTimeMax) {
        this.dispatchTimeMax = dispatchTimeMax;
    }

    /**
     * Sets new Location of item..
     *
     * @param location
     *         New value of Location of item..
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets Ebay ID for conidition up to 1000..
     *
     * @return Value of Ebay ID for conidition up to 1000..
     */
    public Integer getConditionID() {
        return conditionID;
    }

    /**
     * Sets new Title of listing..
     *
     * @param title
     *         New value of Title of listing..
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets Start price for bidding purposes..
     *
     * @return Value of Start price for bidding purposes..
     */
    public Double getStartPrice() {
        return startPrice;
    }

    /**
     * Gets Postal code of item ..
     *
     * @return Value of Postal code of item ..
     */
    public String getPostalCode() {
        return PostalCode;
    }

    /**
     * Sets new Price that bidding stops once reserve is hit - item is sold..
     *
     * @param reservePrice
     *         New value of Price that bidding stops once reserve is hit - item is sold..
     */
    public void setReservePrice(Double reservePrice) {
        this.reservePrice = reservePrice;
    }

    /**
     * Sets new Email address of seller..
     *
     * @param paypalEmailAddress
     *         New value of Email address of seller..
     */
    public void setPaypalEmailAddress(String paypalEmailAddress) {
        this.paypalEmailAddress = paypalEmailAddress;
    }

    /**
     * Sets new Details for picking up in store..
     *
     * @param pickupInStoreDetails
     *         New value of Details for picking up in store..
     */
    public void setPickupInStoreDetails(PickupInStoreDetails pickupInStoreDetails) {
        this.pickupInStoreDetails = pickupInStoreDetails;
    }

    /**
     * Gets Locationss item can be shipped to..
     *
     * @return Value of Locationss item can be shipped to..
     */
    public String getShipToLocations() {
        return shipToLocations;
    }

    /**
     * Sets new Accepted payment methods..
     *
     * @param buyerMethodCodeType
     *         New value of Accepted payment methods..
     */
    public void setBuyerMethodCodeType(List<PaymentMethodCodeType> buyerMethodCodeType) {
        this.buyerMethodCodeType = buyerMethodCodeType;
    }

    /**
     * Sets new Item description..
     *
     * @param description
     *         New value of Item description..
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets Primary category item fits into..
     *
     * @return Value of Primary category item fits into..
     */
    public PrimaryCategory getPrimaryCategory() {
        return primaryCategory;
    }

    /**
     * Sets new Item specific data can store custom references..
     *
     * @param applicationData
     *         New value of Item specific data can store custom references..
     */
    public void setApplicationData(String applicationData) {
        this.applicationData = applicationData;
    }

    /**
     * Gets Item description..
     *
     * @return Value of Item description..
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets new Primary category item fits into..
     *
     * @param primaryCategory
     *         New value of Primary category item fits into..
     */
    public void setPrimaryCategory(PrimaryCategory primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    /**
     * Sets new Details of package item is shipped in..
     *
     * @param shippingPackageDetails
     *         New value of Details of package item is shipped in..
     */
    public void setShippingPackageDetails(ShippingPackageDetails shippingPackageDetails) {
        this.shippingPackageDetails = shippingPackageDetails;
    }

    /**
     * Gets Item specific data can store custom references..
     *
     * @return Value of Item specific data can store custom references..
     */
    public String getApplicationData() {
        return applicationData;
    }

    /**
     * Gets Secondary category item fits into..
     *
     * @return Value of Secondary category item fits into..
     */
    public SecondaryCategory getSecondaryCategory() {
        return secondaryCategory;
    }

    /**
     * Gets Country of item origin..
     *
     * @return Value of Country of item origin..
     */
    public CountryCodeType getCountry() {
        return country;
    }

    /**
     * Sets new Country of item origin..
     *
     * @param country
     *         New value of Country of item origin..
     */
    public void setCountry(CountryCodeType country) {
        this.country = country;
    }

    /**
     * Gets Title of listing..
     *
     * @return Value of Title of listing..
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets Location of item..
     *
     * @return Value of Location of item..
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets Currency for item purchasing data..
     *
     * @return Value of Currency for item purchasing data..
     */
    public CurrencyCodeType getCurrencyCodeType() {
        return currencyCodeType;
    }

    /**
     * Sets new Duration item to be listed..
     *
     * @param listingDuration
     *         New value of Duration item to be listed..
     */
    public void setListingDuration(ListingDuration listingDuration) {
        this.listingDuration = listingDuration;
    }

    /**
     * Gets Quantity of item available..
     *
     * @return Value of Quantity of item available..
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets new Postal code of item ..
     *
     * @param PostalCode
     *         New value of Postal code of item ..
     */
    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    /**
     * Gets Description of item condition..
     *
     * @return Value of Description of item condition..
     */
    public String getConditionDescription() {
        return conditionDescription;
    }

    /**
     * Gets Price that bidding stops once reserve is hit - item is sold..
     *
     * @return Value of Price that bidding stops once reserve is hit - item is sold..
     */
    public Double getReservePrice() {
        return reservePrice;
    }

    /**
     * Sets new Unique reference again custom reference that can hold numori specific data..
     *
     * @param UUID
     *         New value of Unique reference again custom reference that can hold numori specific data..
     */
    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    /**
     * Gets Number of days before dispatch time after cleared payment doesn't include shipping time.
     *
     * @return Value of Number of days before dispatch time after cleared payment doesn't include shipping time.
     */
    public Integer getDispatchTimeMax() {
        return dispatchTimeMax;
    }

    /**
     * Sets new Start price for bidding purposes..
     *
     * @param startPrice
     *         New value of Start price for bidding purposes..
     */
    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    /**
     * Sets new Currency for item purchasing data..
     *
     * @param currencyCodeType
     *         New value of Currency for item purchasing data..
     */
    public void setCurrencyCodeType(CurrencyCodeType currencyCodeType) {
        this.currencyCodeType = currencyCodeType;
    }

    /**
     * Sets new Locationss item can be shipped to..
     *
     * @param shipToLocations
     *         New value of Locationss item can be shipped to..
     */
    public void setShipToLocations(String shipToLocations) {
        this.shipToLocations = shipToLocations;
    }

    /**
     * Sets new Secondary category item fits into..
     *
     * @param secondaryCategory
     *         New value of Secondary category item fits into..
     */
    public void setSecondaryCategory(SecondaryCategory secondaryCategory) {
        this.secondaryCategory = secondaryCategory;
    }

    /**
     * Sets new Shipping details..
     *
     * @param shippingDetails
     *         New value of Shipping details..
     */
    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    /**
     * Gets Unique reference again custom reference that can hold numori specific data..
     *
     * @return Value of Unique reference again custom reference that can hold numori specific data..
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * Sets new Ebay ID for conidition up to 1000..
     *
     * @param conditionID
     *         New value of Ebay ID for conidition up to 1000..
     */
    public void setConditionID(Integer conditionID) {
        this.conditionID = conditionID;
    }

    /**
     * Gets Details for picking up in store..
     *
     * @return Value of Details for picking up in store..
     */
    public PickupInStoreDetails getPickupInStoreDetails() {
        return pickupInStoreDetails;
    }

    /**
     * Gets Details of package item is shipped in..
     *
     * @return Value of Details of package item is shipped in..
     */
    public ShippingPackageDetails getShippingPackageDetails() {
        return shippingPackageDetails;
    }

    /**
     * Gets Shipping details..
     *
     * @return Value of Shipping details..
     */
    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    /**
     * Gets Duration item to be listed..
     *
     * @return Value of Duration item to be listed..
     */
    public ListingDuration getListingDuration() {
        return listingDuration;
    }

    /**
     * Sets new Quantity of item available..
     *
     * @param quantity
     *         New value of Quantity of item available..
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets new Sales tax details..
     *
     * @param salesTax
     *         New value of Sales tax details..
     */
    public void setSalesTax(SalesTax salesTax) {
        this.salesTax = salesTax;
    }

    /**
     * Gets Sales tax details..
     *
     * @return Value of Sales tax details..
     */
    public SalesTax getSalesTax() {
        return salesTax;
    }

    /**
     * Gets Details surrounding pricing of listing..
     *
     * @return Value of Details surrounding pricing of listing..
     */
    public ListingDetails getListingDetails() {
        return listingDetails;
    }

    /**
     * Sets new Details surrounding pricing of listing..
     *
     * @param listingDetails
     *         New value of Details surrounding pricing of listing..
     */
    public void setListingDetails(ListingDetails listingDetails) {
        this.listingDetails = listingDetails;
    }
}
