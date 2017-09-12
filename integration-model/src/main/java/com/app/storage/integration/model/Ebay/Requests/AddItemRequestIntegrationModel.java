package com.app.storage.integration.model.Ebay.Requests;

import com.app.storage.integration.IntegrationConstants;
import com.app.storage.integration.model.Ebay.SubModels.AddItemIntegrationModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Ebay Add Item Request XML model.
 */
@XmlRootElement(name = "AddItemRequest")
public class AddItemRequestIntegrationModel {

    /** Full details of add item listing model. */
    @XmlElement(name = "Item")
    private AddItemIntegrationModel addItemIntegrationModel;

    /** Version of api. */
    @XmlElement(name = "Version")
    private String version = IntegrationConstants.API_VERSION_NUMBER;


    /**
     * Sets new Full details of add item listing model..
     *
     * @param addItemIntegrationModel
     *         New value of Full details of add item listing model..
     */
    public void setAddItemIntegrationModel(AddItemIntegrationModel addItemIntegrationModel) {
        this.addItemIntegrationModel = addItemIntegrationModel;
    }

    /**
     * Gets Full details of add item listing model..
     *
     * @return Value of Full details of add item listing model..
     */
    public AddItemIntegrationModel getAddItemIntegrationModel() {
        return addItemIntegrationModel;
    }

    /**
     * Gets Version of api..
     *
     * @return Value of Version of api..
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets new Version of api..
     *
     * @param version
     *         New value of Version of api..
     */
    public void setVersion(String version) {
        this.version = version;
    }
}
