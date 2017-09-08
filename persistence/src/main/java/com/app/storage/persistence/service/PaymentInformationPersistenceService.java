package com.app.storage.persistence.service;

import com.app.storage.domain.model.payment.PaymentInformation;

/**
 * Payment information persistence service.
 */
public interface PaymentInformationPersistenceService {


    /**
     * Updates user payment information.
     *
     * @param userEmail
     *         Unique user reference.
     * @param paymentInformation
     *         New payment information.
     */
    void updateUserPaymentInformation(String userEmail, PaymentInformation paymentInformation);
}
