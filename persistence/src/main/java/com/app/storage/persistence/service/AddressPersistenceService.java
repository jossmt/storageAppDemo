package com.app.storage.persistence.service;

import com.app.storage.domain.model.Address;

/**
 * Address persistence service.
 */
public interface AddressPersistenceService {


    /**
     * Updates user address details.
     *
     * @param email
     *         Unique user reference.
     * @param address
     *         {@link Address}
     */
    void updateUserAddress(String email, Address address);
}
