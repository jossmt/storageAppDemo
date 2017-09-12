package com.app.storage.integration.model.Ebay.SubModels.Policies.Shipping;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Shipping package details.
 */
@XmlRootElement(name = "ShippingPackageDetails")
public class ShippingPackageDetails {

    /** Measurement unit. */
    @XmlElement(name = "MeasurementUnit")
    private MeasurementSystemCode packageMeasurementUnit;

    /** Package depth. */
    @XmlElement(name = "PackageDepth")
    private Double packageDepth;

    /** Package width. */
    @XmlElement(name = "PackageWidth")
    private Double packageWidth;

    /** Package length. */
    @XmlElement(name = "PackageLength")
    private Double packageLength;

    /** Shipping package type. */
    @XmlElement(name = "ShippingPackage")
    private ShippingPackageCode shippingPackage;

    /** Measurement system. */
    @XmlAttribute(name = "measurementSystem")
    private MeasurementSystemCode measurementSystemCode;

    /** Unit of measurement. */
    @XmlAttribute(name = "unit")
    private MeasurementUnit measurementUnit;

    /** Weight major refers to the larger units measurement. */
    @XmlElement(name = "WeightMajor")
    private Double weightMajor;

    /** Weight minor refers to the smaller units measurement so weightmajor=2lbs weightminor=2oz. */
    @XmlElement(name = "WeightMinor")
    private Double weightMinor;


    /**
     * Sets new Shipping package type..
     *
     * @param shippingPackage
     *         New value of Shipping package type..
     */
    public void setShippingPackage(ShippingPackageCode shippingPackage) {
        this.shippingPackage = shippingPackage;
    }

    /**
     * Gets Package width..
     *
     * @return Value of Package width..
     */
    public Double getPackageWidth() {
        return packageWidth;
    }

    /**
     * Sets new Measurement unit..
     *
     * @param measurementUnit
     *         New value of Measurement unit..
     */
    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    /**
     * Gets Measurement system..
     *
     * @return Value of Measurement system..
     */
    public MeasurementSystemCode getMeasurementSystemCode() {
        return measurementSystemCode;
    }

    /**
     * Sets new Weight major refers to the larger units measurement..
     *
     * @param weightMajor
     *         New value of Weight major refers to the larger units measurement..
     */
    public void setWeightMajor(Double weightMajor) {
        this.weightMajor = weightMajor;
    }

    /**
     * Gets Weight minor refers to the smaller units measurement so weightmajor=2lbs weightminor=2oz..
     *
     * @return Value of Weight minor refers to the smaller units measurement so weightmajor=2lbs weightminor=2oz..
     */
    public Double getWeightMinor() {
        return weightMinor;
    }

    /**
     * Sets new Package width..
     *
     * @param packageWidth
     *         New value of Package width..
     */
    public void setPackageWidth(Double packageWidth) {
        this.packageWidth = packageWidth;
    }

    /**
     * Sets new Package length..
     *
     * @param packageLength
     *         New value of Package length..
     */
    public void setPackageLength(Double packageLength) {
        this.packageLength = packageLength;
    }

    /**
     * Gets Shipping package type..
     *
     * @return Value of Shipping package type..
     */
    public ShippingPackageCode getShippingPackage() {
        return shippingPackage;
    }

    /**
     * Sets new Measurement system..
     *
     * @param measurementSystemCode
     *         New value of Measurement system..
     */
    public void setMeasurementSystemCode(MeasurementSystemCode measurementSystemCode) {
        this.measurementSystemCode = measurementSystemCode;
    }

    /**
     * Gets Measurement unit..
     *
     * @return Value of Measurement unit..
     */
    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    /**
     * Gets Package length..
     *
     * @return Value of Package length..
     */
    public Double getPackageLength() {
        return packageLength;
    }

    /**
     * Gets Weight major refers to the larger units measurement..
     *
     * @return Value of Weight major refers to the larger units measurement..
     */
    public Double getWeightMajor() {
        return weightMajor;
    }

    /**
     * Gets Package depth..
     *
     * @return Value of Package depth..
     */
    public Double getPackageDepth() {
        return packageDepth;
    }

    /**
     * Sets new Package depth..
     *
     * @param packageDepth
     *         New value of Package depth..
     */
    public void setPackageDepth(Double packageDepth) {
        this.packageDepth = packageDepth;
    }

    /**
     * Sets new Weight minor refers to the smaller units measurement so weightmajor=2lbs weightminor=2oz..
     *
     * @param weightMinor
     *         New value of Weight minor refers to the smaller units measurement so weightmajor=2lbs weightminor=2oz..
     */
    public void setWeightMinor(Double weightMinor) {
        this.weightMinor = weightMinor;
    }

    /**
     * Gets Measurement unit..
     *
     * @return Value of Measurement unit..
     */
    public MeasurementSystemCode getPackageMeasurementUnit() {
        return packageMeasurementUnit;
    }

    /**
     * Sets new Measurement unit..
     *
     * @param packageMeasurementUnit
     *         New value of Measurement unit..
     */
    public void setPackageMeasurementUnit(MeasurementSystemCode packageMeasurementUnit) {
        this.packageMeasurementUnit = packageMeasurementUnit;
    }
}
