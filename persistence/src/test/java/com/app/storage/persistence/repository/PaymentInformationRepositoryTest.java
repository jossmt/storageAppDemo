package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.model.payment.PaymentInformationPersistenceModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test for {@link PaymentInformationRepository}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:JDBCConfig.xml"})
public class PaymentInformationRepositoryTest {

    /** {@link PaymentInformationRepository}. */
    @Autowired
    private PaymentInformationRepository paymentInformationRepository;

    /** {@link UserRepository}. */
    @Autowired
    private UserRepository userRepository;

    /**
     * Test basic save function.
     */
    @Test
    public void testSave() {

        //Setup
        final UserPersistenceModel userPersistenceModel = userRepository.findMostRecent();

        final PaymentInformationPersistenceModel paymentInformationPersistenceModel = new PaymentInformationPersistenceModel();
        paymentInformationPersistenceModel.setCardNumber(99944449994L);
        paymentInformationPersistenceModel.setCardHolderName("Card Holder Name");
        paymentInformationPersistenceModel.setExpirationMonth(02);
        paymentInformationPersistenceModel.setExpirationYear(2019);
        paymentInformationPersistenceModel.setCvv(123);
        paymentInformationPersistenceModel.setUserPersistenceModel(userPersistenceModel);

        //Test
        final PaymentInformationPersistenceModel paymentInformationPersistenceModelSaved = paymentInformationRepository.save
                (paymentInformationPersistenceModel);

        final PaymentInformationPersistenceModel paymentInformationPersistenceModelUpdated = paymentInformationRepository
                .findMostRecent();

        //Assert
        Assert.assertEquals(paymentInformationPersistenceModelSaved, paymentInformationPersistenceModelUpdated);

        //Clear
        paymentInformationRepository.delete(paymentInformationPersistenceModelUpdated.getId());
    }
}
