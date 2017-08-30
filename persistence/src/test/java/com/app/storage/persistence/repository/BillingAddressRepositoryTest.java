package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.model.payment.BillingAddressPersistenceModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests for {@link BillingAddressRepository}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:JDBCConfig.xml"})
public class BillingAddressRepositoryTest {

    /** {@link BillingAddressRepository}. */
    @Autowired
    private BillingAddressRepository billingAddressRepository;

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

        final BillingAddressPersistenceModel billingAddressPersistenceModel = new BillingAddressPersistenceModel();
        billingAddressPersistenceModel.setRegion("region");
        billingAddressPersistenceModel.setCountry("country");
        billingAddressPersistenceModel.setPostCode("postcode");
        billingAddressPersistenceModel.setStreetAddress("street address");
        billingAddressPersistenceModel.setUserPersistenceModel(userPersistenceModel);

        //Test
        final BillingAddressPersistenceModel billingAddressPersistenceModelSaved = billingAddressRepository.save
                (billingAddressPersistenceModel);

        final BillingAddressPersistenceModel billingAddressPersistenceModelUpdated = billingAddressRepository
                .findMostRecent();

        //Assert
        Assert.assertEquals(billingAddressPersistenceModelSaved, billingAddressPersistenceModelUpdated);

        //Clear
        billingAddressRepository.delete(billingAddressPersistenceModelUpdated.getId());
    }
}
