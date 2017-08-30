package com.app.storage.persistence.mapper.payment;

import com.app.storage.domain.model.payment.BillingAddress;
import com.app.storage.persistence.model.payment.BillingAddressPersistenceModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link BillingAddressPersistenceMapper}
 */
public class BillingAddressPersistenceMapperTest {

    /** {@link BillingAddressPersistenceMapper} */
    private BillingAddressPersistenceMapper billingAddressPersistenceMapper;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        billingAddressPersistenceMapper = new BillingAddressPersistenceMapperHandler();
    }


    /**
     * Full Map To Test.
     */
    @Test
    public void checkFullMapTo() {

        //Setup
        final BillingAddress billingAddress = new BillingAddress();
        billingAddress.setCountryName("Country");
        billingAddress.setPostcode("se10su");
        billingAddress.setRegion("region");
        billingAddress.setStreetAddress("street address");

        final BillingAddressPersistenceModel billingAddressPersistenceModel = new BillingAddressPersistenceModel();
        billingAddressPersistenceModel.setCountry("Country");
        billingAddressPersistenceModel.setPostCode("se10su");
        billingAddressPersistenceModel.setRegion("region");
        billingAddressPersistenceModel.setStreetAddress("street address");

        //test
        final BillingAddressPersistenceModel billingAddressPersistenceModelActual = billingAddressPersistenceMapper
                .mapTo(billingAddress);

        //Assert
        Assert.assertEquals(billingAddressPersistenceModel, billingAddressPersistenceModelActual);
    }

    /**
     * Full Map From Test.
     */
    @Test
    public void checkFullMapFrom() {

        //Setup
        final BillingAddress billingAddress = new BillingAddress();
        billingAddress.setCountryName("Country");
        billingAddress.setPostcode("se10su");
        billingAddress.setRegion("region");
        billingAddress.setStreetAddress("street address");

        final BillingAddressPersistenceModel billingAddressPersistenceModel = new BillingAddressPersistenceModel();
        billingAddressPersistenceModel.setCountry("Country");
        billingAddressPersistenceModel.setPostCode("se10su");
        billingAddressPersistenceModel.setRegion("region");
        billingAddressPersistenceModel.setStreetAddress("street address");

        //test
        final BillingAddress billingAddressActual = billingAddressPersistenceMapper
                .mapFrom(billingAddressPersistenceModel);

        //Assert
        Assert.assertEquals(billingAddress, billingAddressActual);
    }
}
