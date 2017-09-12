package com.app.storage.integration.model.Ebay.SubModels.Policies.Warranty;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Warranty duration of item listing.
 */
@XmlRootElement(name = "WarrantyDurationOption")
@XmlAccessorType(XmlAccessType.FIELD)
public enum WarrantyTypeOption {

    DealerWarranty,

    ManufacturerWarranty,

    ReplacementWarranty
}
