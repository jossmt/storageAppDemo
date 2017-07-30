package com.app.storage.service;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.service.StorageItemPersistenceService;
import com.app.storage.persistence.service.UserPersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link StorageItemService}
 */
@Service
public class StorageItemServiceHandler implements StorageItemService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(StorageItemService.class);

    /** {@link StorageItemPersistenceService} */
    private final StorageItemPersistenceService storageItemPersistenceService;

    /**
     * Constructor.
     *
     * @param storageItemPersistenceService
     *         {@link StorageItemPersistenceService}
     */
    @Autowired
    public StorageItemServiceHandler(final StorageItemPersistenceService storageItemPersistenceService) {
        this.storageItemPersistenceService = storageItemPersistenceService;
    }

    /**
     * {@inheritDoc}
     */
    public List<StorageItem> retrieveAllStorageItems() {

        LOG.debug("Retrieving storage items.");

        final List<StorageItem> storageItems = storageItemPersistenceService.retrieveAllStorageItems();

        LOG.debug("Successfully retrieved storage items: {}", storageItems);

        return storageItems;
    }

    /**
     * {@inheritDoc}
     */
    public void saveStorageItems(final List<StorageItem> storageItems) {

        LOG.debug("Saving storage items");

        storageItemPersistenceService.saveStorageItems(storageItems);

        LOG.debug("Success saving storage items.");
    }
}
