package com.app.storage.persistence.mapper.payment;

import com.app.storage.domain.model.payment.BillingAddress;
import com.app.storage.persistence.model.payment.BillingAddressPersistenceModel;

/**
 * Billing Address Persistence Mapper.
 */
public interface BillingAddressPersistenceMapper {

    /**
     * Maps from {@link BillingAddress} to {@link BillingAddressPersistenceModel}
     *
     * @param billingAddress
     *         {@link BillingAddress}
     * @return {@link BillingAddressPersistenceModel}
     */
    BillingAddressPersistenceModel mapTo(BillingAddress billingAddress);

    /**
     * Maps from {@link BillingAddressPersistenceModel} to {@link BillingAddress}
     *
     * @param billingAddressPersistenceModel
     *         {@link BillingAddressPersistenceModel}
     * @return {@link BillingAddress}
     */
    BillingAddress mapFrom(BillingAddressPersistenceModel billingAddressPersistenceModel);
}
