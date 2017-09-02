package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.model.payment.AddressPersistenceModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests for {@link AddressRepository}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:JDBCConfig.xml"})
public class AddressRepositoryTest {

    /** {@link AddressRepository}. */
    @Autowired
    private AddressRepository addressRepository;

    /** {@link UserRepository}. */
    @Autowired
    private UserRepository userRepository;

    /**
     * Test save billing address
     */
    @Test
    public void testSave() {
        //Setup
        final UserPersistenceModel userPersistenceModel = userRepository.findMostRecent();

        final AddressPersistenceModel addressPersistenceModel = new AddressPersistenceModel();
        addressPersistenceModel.setRegion("region");
        addressPersistenceModel.setCountry("country");
        addressPersistenceModel.setPostCode("postcode");
        addressPersistenceModel.setStreetAddress("street address");
        addressPersistenceModel.setAddressType("BILLING");
        addressPersistenceModel.setUserPersistenceModel(userPersistenceModel);

        //Test
        final AddressPersistenceModel addressPersistenceModelSaved = addressRepository.save
                (addressPersistenceModel);

        final AddressPersistenceModel addressPersistenceModelUpdated = addressRepository
                .findMostRecent();

        //Assert
        Assert.assertEquals(addressPersistenceModelSaved, addressPersistenceModelUpdated);

        //Clear
        addressRepository.delete(addressPersistenceModelUpdated.getId());
    }
}
