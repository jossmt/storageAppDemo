package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.Address;
import com.app.storage.domain.model.AddressType;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.model.payment.AddressPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link AddressPersistenceMapper}
 */
@Component
public class AddressPersistenceMapperHandler implements AddressPersistenceMapper,
        AbstractMapper<AddressPersistenceModel, Address> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(AddressPersistenceMapper.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressPersistenceModel mapTo(final Address address) {

        LOG.debug("Mapping billing address domain model to persistence model: {}", address);

        AddressPersistenceModel addressPersistenceModel = null;
        if (address != null) {

            addressPersistenceModel = new AddressPersistenceModel();
            addressPersistenceModel.setCountry(address.getCountryName());
            addressPersistenceModel.setPostCode(address.getPostcode());
            addressPersistenceModel.setRegion(address.getRegion());
            addressPersistenceModel.setStreetAddress(address.getStreetAddress());
            addressPersistenceModel.setAddressType(address.getAddressType().toString());
        }

        LOG.debug("Successfully mapped billing address persistence model to domain model: {}",
                  addressPersistenceModel);

        return addressPersistenceModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Address mapFrom(final AddressPersistenceModel addressPersistenceModel) {

        LOG.debug("Mapping persistence model: {} to domain model", addressPersistenceModel);

        Address address = null;
        if (addressPersistenceModel != null) {

            address = new Address();
            address.setStreetAddress(addressPersistenceModel.getStreetAddress());
            address.setRegion(addressPersistenceModel.getRegion());
            address.setPostcode(addressPersistenceModel.getPostCode());
            address.setCountryName(addressPersistenceModel.getCountry());
            address.setAddressType(AddressType.valueOf(addressPersistenceModel.getAddressType()));
        }

        LOG.debug("Successfully mapped to domain model: {}", address);

        return address;
    }
}
