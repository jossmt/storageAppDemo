package com.app.storage.service.payment;

import com.app.storage.domain.model.payment.PaymentTransaction;
import com.braintreegateway.BraintreeGateway;

/**
 * Service to handle braintree gateway payment functionality.
 */
public interface PaymentService {

    /**
     * Initialises gateway from config
     *
     * @return {@link BraintreeGateway}
     */
    BraintreeGateway initialiseGateway();

    /**
     * Generates client token for payment requests.
     *
     * @return String formatted client token.
     */
    String generateClientToken();

    /**
     * Executes payment transaction.
     *
     * @param paymentTransaction
     *         {@link PaymentTransaction}
     * @return Success/Failed payment.
     */
    boolean executeTransaction(PaymentTransaction paymentTransaction);
}
