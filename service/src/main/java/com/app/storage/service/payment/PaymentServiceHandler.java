package com.app.storage.service.payment;

import com.app.storage.domain.model.payment.PaymentTransaction;
import com.app.storage.service.ServiceConstants;
import com.braintreegateway.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Properties;

/**
 * Implementation of {@link PaymentService}
 */
@Service
public class PaymentServiceHandler implements PaymentService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);

    /** Properties. */
    private final Properties properties = new Properties();

    /** Paypal Braintree Gateway. */
    private BraintreeGateway braintreeGateway;

    /**
     * {@inheritDoc}
     */
    @Override
    public BraintreeGateway initialiseGateway() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = null;

        try {
            inputStream = classLoader.getResourceAsStream(ServiceConstants.SANDBOX_PROP_PATH);
            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        braintreeGateway = new

                BraintreeGateway(
                properties.getProperty("BT_ENVIRONMENT"),
                properties.getProperty("BT_MERCHANT_ID"),
                properties.getProperty("BT_PUBLIC_KEY"),
                properties.getProperty("BT_PRIVATE_KEY")
        );

        LOG.debug("Successfully initialised braintree gateway");

        return braintreeGateway;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateClientToken() {

        LOG.debug("Generating client token.");


        final String userToken;
        if (braintreeGateway != null) {

            userToken = braintreeGateway.clientToken().generate();

        } else {
            LOG.error("Braintree gateway has not been initialised.");
            throw new IllegalStateException("Unable to generate client token");
        }

        LOG.debug("Successfully generated user token: {}", userToken);

        return userToken;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean executeTransaction(final PaymentTransaction paymentTransaction) {

        LOG.debug("Making payment for transaction: {}", paymentTransaction);

        final DecimalFormat df = new DecimalFormat("#.00");
        final String doubleFormatted = df.format(paymentTransaction.getTransactionAmount());
        final BigDecimal bigDecimal = new BigDecimal(doubleFormatted);

        TransactionRequest request = new TransactionRequest()
                .amount(bigDecimal)
                .paymentMethodNonce(paymentTransaction.getPaymentNonce())
//                .customerId(paymentTransaction.getCustomerRef())

                // Credit card details.
                .creditCard()
                .cardholderName(paymentTransaction.getCardInformation().getCardHolderName())
                .cvv(paymentTransaction.getCardInformation().getCvvValue().toString())
                .expirationMonth(paymentTransaction.getCardInformation().getExpirationMonth())
                .expirationYear(paymentTransaction.getCardInformation().getExpirationYear())
                .done()

                // Billing Address Details
                .billingAddress()
                .countryName(paymentTransaction.getBillingAddress().getCountryName())
                .region(paymentTransaction.getBillingAddress().getRegion())
                .streetAddress(paymentTransaction.getBillingAddress().getStreetAddress())
                .postalCode(paymentTransaction.getBillingAddress().getPostcode())
                .done()

                // Other
                .options()
                .submitForSettlement(true)
                .done();

        Result<Transaction> result = braintreeGateway.transaction().sale(request);

        if (!result.isSuccess()) {
            try {
                for (final ValidationError validationError : result.getErrors().getAllDeepValidationErrors()) {
                    LOG.error("Deep Error: {}", validationError.getMessage());
                }
            } catch (Exception e) {
                for (final ValidationError validationError : result.getErrors().getAllValidationErrors()) {
                    LOG.error("Deep Error: {}", validationError.getMessage());
                }
            }

            throw new IllegalStateException("Payment was denied.");
        }

        LOG.debug("Execution status of transaction is: {}", result.isSuccess());

        return result.isSuccess();
    }
}
