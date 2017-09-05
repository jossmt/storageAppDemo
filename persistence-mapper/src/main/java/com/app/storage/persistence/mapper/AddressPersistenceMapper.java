package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.Address;
import com.app.storage.persistence.model.AddressPersistenceModel;

/**
 * Billing Address Persistence Mapper.
 */
public interface AddressPersistenceMapper {

    /**
     * Maps from {@link Address} to {@link AddressPersistenceModel}
     *
     * @param address
     *         {@link Address}
     * @return {@link AddressPersistenceModel}
     */
    AddressPersistenceModel mapTo(Address address);

    /**
     * Maps from {@link AddressPersistenceModel} to {@link Address}
     *
     * @param addressPersistenceModel
     *         {@link AddressPersistenceModel}
     * @return {@link Address}
     */
    Address mapFrom(AddressPersistenceModel addressPersistenceModel);
}
