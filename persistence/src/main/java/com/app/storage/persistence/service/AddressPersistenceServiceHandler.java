package com.app.storage.persistence.service;

import com.app.storage.domain.model.Address;
import com.app.storage.persistence.mapper.AddressPersistenceMapper;
import com.app.storage.persistence.model.AddressPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.repository.AddressRepository;
import com.app.storage.persistence.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link AddressPersistenceService}
 */
@Service
public class AddressPersistenceServiceHandler implements AddressPersistenceService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(AddressPersistenceService.class);

    /** {@link UserRepository}. */
    private UserRepository userRepository;

    /** {@link AddressRepository}. */
    private AddressRepository addressRepository;

    /** {@link AddressPersistenceMapper}. */
    private AddressPersistenceMapper addressPersistenceMapper;


    /**
     * Constructor
     */
    @Autowired
    public AddressPersistenceServiceHandler(final UserRepository userRepository,
                                            final AddressRepository addressRepository,
                                            final AddressPersistenceMapper addressPersistenceMapper) {

        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.addressPersistenceMapper = addressPersistenceMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void updateUserAddress(final String userEmail, final Address address) {

        LOG.debug("Updating user address {} for user {}", address, userEmail);

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail(userEmail);
        final AddressPersistenceModel addressPersistenceModel = addressPersistenceMapper.mapTo(address);

        LOG.debug("Addresses before: {}", userPersistenceModel.getAddressPersistenceModels().toString());

        addressPersistenceModel.setUserPersistenceModel(userPersistenceModel);

        final AddressPersistenceModel addressPersistenceModelSaved = addressRepository.save(addressPersistenceModel);
        userPersistenceModel.addAddress(addressPersistenceModelSaved);

        LOG.debug("Addresses after: {}", userPersistenceModel.getAddressPersistenceModels().toString());

        userPersistenceModel.removeAllDuplicateAddress();

        LOG.debug("Addresses after duplicate removal: {}", userPersistenceModel.getAddressPersistenceModels());

        LOG.debug("Successfully updated address for user.");

    }
}
