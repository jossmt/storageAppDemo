package com.app.storage.persistence.mapper.payment;

import com.app.storage.domain.model.payment.PaymentInformation;
import com.app.storage.persistence.model.payment.PaymentInformationPersistenceModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link PaymentInformationPersistenceMapper}
 */
public class PaymentInformationPersistenceMapperTest {

    /** {@link PaymentInformationPersistenceMapper}. */
    private PaymentInformationPersistenceMapper paymentInformationPersistenceMapper;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        paymentInformationPersistenceMapper = new PaymentInformationPersistenceMapperHandler();
    }

    /**
     * Check full map to persistence model test.
     */
    @Test
    public void checkFullMapTo() {

        //Setup
        final PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setExpirationYear(2019);
        paymentInformation.setExpirationMonth(02);
        paymentInformation.setCardNumber(4762300018009393L);
        paymentInformation.setCvvValue(133);
        paymentInformation.setCardHolderName("Card Holder Name");
        paymentInformation.setPaypalUsername("paypaluser");

        final PaymentInformationPersistenceModel paymentInformationPersistenceModel = new
                PaymentInformationPersistenceModel();
        paymentInformationPersistenceModel.setExpirationYear(2019);
        paymentInformationPersistenceModel.setExpirationMonth(02);
        paymentInformationPersistenceModel.setCardNumber(4762300018009393L);
        paymentInformationPersistenceModel.setCvv(133);
        paymentInformationPersistenceModel.setCardHolderName("Card Holder Name");
        paymentInformationPersistenceModel.setPaypalUsername("paypaluser");

        //Test
        final PaymentInformationPersistenceModel paymentInformationPersistenceModelActual =
                paymentInformationPersistenceMapper
                .mapTo(paymentInformation);

        //Assert
        Assert.assertEquals(paymentInformationPersistenceModelActual, paymentInformationPersistenceModel);

    }

    /**
     * Check full map from persistence model test.
     */
    @Test
    public void checkFullMapFrom() {

        //Setup
        final PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setExpirationYear(2019);
        paymentInformation.setExpirationMonth(02);
        paymentInformation.setCardNumber(4762300018009393L);
        paymentInformation.setCvvValue(133);
        paymentInformation.setCardHolderName("Card Holder Name");
        paymentInformation.setPaypalUsername("paypaluser");

        final PaymentInformationPersistenceModel paymentInformationPersistenceModel = new
                PaymentInformationPersistenceModel();
        paymentInformationPersistenceModel.setExpirationYear(2019);
        paymentInformationPersistenceModel.setExpirationMonth(02);
        paymentInformationPersistenceModel.setCardNumber(4762300018009393L);
        paymentInformationPersistenceModel.setCvv(133);
        paymentInformationPersistenceModel.setCardHolderName("Card Holder Name");
        paymentInformationPersistenceModel.setPaypalUsername("paypaluser");


        //Test
        final PaymentInformation paymentInformationActual = paymentInformationPersistenceMapper.mapFrom
                (paymentInformationPersistenceModel);

        //Assert
        Assert.assertEquals(paymentInformation, paymentInformationActual);
    }
}
