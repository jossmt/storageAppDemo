package com.app.storage.service.payment;

import com.app.storage.domain.model.Address;
import com.app.storage.domain.model.payment.PaymentInformation;
import com.app.storage.domain.model.payment.PaymentTransaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


/**
 * Test for {@link PaymentService}
 */
public class PaymentServiceTest {

    /** {@link PaymentService}. */
    private PaymentService paymentService;

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        paymentService = new PaymentServiceHandler();
        paymentService.initialiseGateway();
    }

    /**
     * Ensures gateway is initialised correctly and client token returned.
     */
    @Test
    public void testInitialiseAndClientTokenResponse() {

        final String clientToken = paymentService.generateClientToken();

        //Assert
        Assert.assertNotNull(clientToken);
    }

    /**
     * Test transaction with sandbox dummy account.
     */
    @Test
    public void testTransaction() {

        //Setup
        final Address address = new Address();
        address.setCountryName("United Kingdom");
        address.setPostcode("KT11HS");
        address.setRegion("Kingston");
        address.setStreetAddress("Flat 4 Garricks House, Wadbrook Street");

        final PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setCardHolderName("JOSS RIAN MILLER-TODD");
        paymentInformation.setCardNumber(1234567891011L);
        paymentInformation.setCvvValue(123);
        paymentInformation.setExpirationMonth(02);
        paymentInformation.setExpirationYear(2019);

        final PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setPaymentInformation(paymentInformation);
        paymentTransaction.setAddress(address);
        paymentTransaction.setPaymentNonce("fake-valid-debit-nonce");
        paymentTransaction.setTransactionAmount(10.12);

        //Test
        final boolean result = paymentService.executeTransaction(paymentTransaction);

        //Assert
        Assert.assertTrue(result);
    }

    /**
     * Test transaction with sandbox dummy account using card details.
     */
    @Test
    public void testTransactionCard() {

        //Setup
        final Address address = new Address();
        address.setCountryName("United Kingdom");
        address.setPostcode("KT11HS");
        address.setRegion("Kingston");
        address.setStreetAddress("Flat 4 Garricks House, Wadbrook Street");

        final PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setCardHolderName("JOSS RIAN MILLER-TODD");
        paymentInformation.setCardNumber(1234567891011L);
        paymentInformation.setCvvValue(123);
        paymentInformation.setExpirationMonth(02);
        paymentInformation.setExpirationYear(2019);

        final PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setPaymentInformation(paymentInformation);
        paymentTransaction.setAddress(address);
        paymentTransaction.setPaymentNonce("fake-valid-unknown-indicators-nonce");
        paymentTransaction.setTransactionAmount(10.12);

        //Test
        final boolean result = paymentService.executeTransaction(paymentTransaction);

        //Assert
        Assert.assertTrue(result);
    }
}
