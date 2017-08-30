package com.app.storage.persistence.mapper.payment;

import com.app.storage.domain.model.payment.BillingAddress;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.model.payment.BillingAddressPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link BillingAddressPersistenceMapper}
 */
@Component
public class BillingAddressPersistenceMapperHandler implements BillingAddressPersistenceMapper,
        AbstractMapper<BillingAddressPersistenceModel, BillingAddress> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(BillingAddressPersistenceMapper.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public BillingAddressPersistenceModel mapTo(final BillingAddress billingAddress) {

        LOG.debug("Mapping billing address domain model to persistence model: {}", billingAddress);

        BillingAddressPersistenceModel billingAddressPersistenceModel = null;
        if (billingAddress != null) {

            billingAddressPersistenceModel = new BillingAddressPersistenceModel();
            billingAddressPersistenceModel.setCountry(billingAddress.getCountryName());
            billingAddressPersistenceModel.setPostCode(billingAddress.getPostcode());
            billingAddressPersistenceModel.setRegion(billingAddress.getRegion());
            billingAddressPersistenceModel.setStreetAddress(billingAddress.getStreetAddress());
        }

        LOG.debug("Successfully mapped billing address persistence model to domain model: {}",
                  billingAddressPersistenceModel);

        return billingAddressPersistenceModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BillingAddress mapFrom(final BillingAddressPersistenceModel billingAddressPersistenceModel) {

        LOG.debug("Mapping persistence model: {} to domain model", billingAddressPersistenceModel);

        BillingAddress billingAddress = null;
        if (billingAddressPersistenceModel != null) {

            billingAddress = new BillingAddress();
            billingAddress.setStreetAddress(billingAddressPersistenceModel.getStreetAddress());
            billingAddress.setRegion(billingAddressPersistenceModel.getRegion());
            billingAddress.setPostcode(billingAddressPersistenceModel.getPostCode());
            billingAddress.setCountryName(billingAddressPersistenceModel.getCountry());
        }

        LOG.debug("Successfully mapped to domain model: {}", billingAddress);

        return billingAddress;
    }
}
