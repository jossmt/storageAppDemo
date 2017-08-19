package com.app.storage.persistence.service;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.StorageItemPersistenceMapper;
import com.app.storage.persistence.mapper.UserPersistenceMapper;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.StorageItemPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.repository.StorageItemRepository;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * Implementation of {@link StorageItemPersistenceService}
 */
@Service
public class StorageItemPersistenceServiceHandler implements StorageItemPersistenceService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(StorageItemPersistenceService.class);

    /** {@link AbstractMapper} */
    private final StorageItemPersistenceMapper storageItemPersistenceMapper;

    /** {@link StorageItemRepository} */
    private final StorageItemRepository storageItemRepository;

    /** {@link ListMapper} */
    private final ListMapper listMapper;

    /**
     * Constructor.
     *
     * @param storageItemPersistenceMapper
     *         Storage item persistence mapper.
     */
    @Autowired
    public StorageItemPersistenceServiceHandler(final StorageItemPersistenceMapper storageItemPersistenceMapper,
                                                final StorageItemRepository storageItemRepository,
                                                final ListMapper listMapper) {

        this.listMapper = listMapper;
        this.storageItemPersistenceMapper = storageItemPersistenceMapper;
        this.storageItemRepository = storageItemRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public List<StorageItem> retrieveAllStorageItems() {

        LOG.debug("Retrieving all storage items.");


        final List<StorageItemPersistenceModel> storageItemPersistenceModels = (List<StorageItemPersistenceModel>)
                storageItemRepository.findAll();

        final List<StorageItem> storageItems = listMapper.mapList((AbstractMapper) storageItemPersistenceMapper, false,
                                                                  storageItemPersistenceModels);


        LOG.debug("Successfully retrieved all storage items: {}", storageItems);

        return storageItems;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveStorageItem(final StorageItem storageItem) {

        LOG.debug("Saving storage item to database: {}", storageItem);

        final StorageItemPersistenceModel storageItemPersistenceModel = storageItemPersistenceMapper.mapTo
                (storageItem);

        storageItemRepository.save(storageItemPersistenceModel);

        LOG.debug("Saved storage items to database.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public StorageItem retrieveStorageItemByRef(final String reference) {

        LOG.debug("Fetching storage item by ref");

        final StorageItemPersistenceModel storageItemPersistenceModel = storageItemRepository.findByReference
                (reference);

        StorageItem storageItem;
        if (storageItemPersistenceModel != null) {

            storageItem = storageItemPersistenceMapper.mapFrom(storageItemPersistenceModel);
        } else {
            throw new NotFoundException("Unable to find storage item by reference given");
        }

        LOG.debug("Returning storage item");

        return storageItem;
    }


}
