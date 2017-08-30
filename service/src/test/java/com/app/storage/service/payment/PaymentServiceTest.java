package com.app.storage.service.payment;

import com.app.storage.domain.model.payment.BillingAddress;
import com.app.storage.domain.model.payment.CardInformation;
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
        final BillingAddress billingAddress = new BillingAddress();
        billingAddress.setCountryName("United Kingdom");
        billingAddress.setPostcode("KT11HS");
        billingAddress.setRegion("Kingston");
        billingAddress.setStreetAddress("Flat 4 Garricks House, Wadbrook Street");

        final CardInformation cardInformation = new CardInformation();
        cardInformation.setCardHolderName("JOSS RIAN MILLER-TODD");
        cardInformation.setCardNumber(1234567891011L);
        cardInformation.setCvvValue(123);
        cardInformation.setExpirationMonth(02);
        cardInformation.setExpirationYear(2019);

        final PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setCardInformation(cardInformation);
        paymentTransaction.setBillingAddress(billingAddress);
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
        final BillingAddress billingAddress = new BillingAddress();
        billingAddress.setCountryName("United Kingdom");
        billingAddress.setPostcode("KT11HS");
        billingAddress.setRegion("Kingston");
        billingAddress.setStreetAddress("Flat 4 Garricks House, Wadbrook Street");

        final CardInformation cardInformation = new CardInformation();
        cardInformation.setCardHolderName("JOSS RIAN MILLER-TODD");
        cardInformation.setCardNumber(1234567891011L);
        cardInformation.setCvvValue(123);
        cardInformation.setExpirationMonth(02);
        cardInformation.setExpirationYear(2019);

        final PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setCardInformation(cardInformation);
        paymentTransaction.setBillingAddress(billingAddress);
        paymentTransaction.setPaymentNonce("fake-valid-unknown-indicators-nonce");
        paymentTransaction.setTransactionAmount(10.12);

        //Test
        final boolean result = paymentService.executeTransaction(paymentTransaction);

        //Assert
        Assert.assertTrue(result);
    }
}
