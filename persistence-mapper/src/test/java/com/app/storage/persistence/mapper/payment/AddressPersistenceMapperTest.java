package com.app.storage.persistence.mapper.payment;

import com.app.storage.domain.model.Address;
import com.app.storage.domain.model.AddressType;
import com.app.storage.persistence.mapper.AddressPersistenceMapper;
import com.app.storage.persistence.mapper.AddressPersistenceMapperHandler;
import com.app.storage.persistence.model.AddressPersistenceModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link AddressPersistenceMapper}
 */
public class AddressPersistenceMapperTest {

    /** {@link AddressPersistenceMapper} */
    private AddressPersistenceMapper addressPersistenceMapper;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        addressPersistenceMapper = new AddressPersistenceMapperHandler();
    }


    /**
     * Full Map To Test.
     */
    @Test
    public void checkFullMapTo() {

        //Setup
        final Address address = new Address();
        address.setCountryName("Country");
        address.setPostcode("se10su");
        address.setRegion("region");
        address.setStreetAddress("street address");
        address.setAddressType(AddressType.BILLING);

        final AddressPersistenceModel addressPersistenceModel = new AddressPersistenceModel();
        addressPersistenceModel.setCountry("Country");
        addressPersistenceModel.setPostCode("se10su");
        addressPersistenceModel.setRegion("region");
        addressPersistenceModel.setStreetAddress("street address");
        addressPersistenceModel.setAddressType(AddressType.BILLING.toString());

        //test
        final AddressPersistenceModel addressPersistenceModelActual = addressPersistenceMapper
                .mapTo(address);

        //Assert
        Assert.assertEquals(addressPersistenceModel, addressPersistenceModelActual);
    }

    /**
     * Full Map From Test.
     */
    @Test
    public void checkFullMapFrom() {

        //Setup
        final Address address = new Address();
        address.setCountryName("Country");
        address.setPostcode("se10su");
        address.setRegion("region");
        address.setStreetAddress("street address");
        address.setAddressType(AddressType.BILLING);

        final AddressPersistenceModel addressPersistenceModel = new AddressPersistenceModel();
        addressPersistenceModel.setCountry("Country");
        addressPersistenceModel.setPostCode("se10su");
        addressPersistenceModel.setRegion("region");
        addressPersistenceModel.setStreetAddress("street address");
        addressPersistenceModel.setAddressType(AddressType.BILLING.toString());

        //test
        final Address addressActual = addressPersistenceMapper
                .mapFrom(addressPersistenceModel);

        //Assert
        Assert.assertEquals(address, addressActual);
    }
}
