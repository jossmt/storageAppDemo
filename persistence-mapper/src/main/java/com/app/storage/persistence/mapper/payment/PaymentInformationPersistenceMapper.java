package com.app.storage.persistence.mapper.payment;

import com.app.storage.domain.model.payment.PaymentInformation;
import com.app.storage.persistence.model.payment.PaymentInformationPersistenceModel;

/**
 * Card information persistence mapper.
 */
public interface PaymentInformationPersistenceMapper {

    /**
     * Maps from {@link PaymentInformation} to {@link PaymentInformationPersistenceModel}
     *
     * @param paymentInformation
     *         {@link PaymentInformation}
     * @return {@link PaymentInformationPersistenceModel}
     */
    PaymentInformationPersistenceModel mapTo(PaymentInformation paymentInformation);

    /**
     * Maps from {@link PaymentInformationPersistenceModel} to {@link PaymentInformation}
     *
     * @param paymentInformationPersistenceModel
     *         {@link PaymentInformationPersistenceModel}
     * @return {@link PaymentInformation}
     */
    PaymentInformation mapFrom(PaymentInformationPersistenceModel paymentInformationPersistenceModel);
}
