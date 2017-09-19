@XmlSchema(
        namespace = "urn:ebay:apis:eBLBaseComponents",
        elementFormDefault = XmlNsForm.QUALIFIED,
        attributeFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix="", namespaceURI="urn:ebay:apis:eBLBaseComponents")
        }
)
package com.app.storage.integration.model.Ebay.Requests;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;