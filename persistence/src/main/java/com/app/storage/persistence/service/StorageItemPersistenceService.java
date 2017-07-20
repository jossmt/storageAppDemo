package com.app.storage.persistence.service;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.persistence.model.StorageItemPersistenceModel;

import java.util.List;

/**
 * Storage item persistence service.
 */
public interface StorageItemPersistenceService {

    /**
     * Retrieves all storage items.
     *
     * @return {@link StorageItemPersistenceModel}
     */
    List<StorageItem> retrieveAllStorageItems();

    /**
     * Saves all storage items in database.
     *
     * @param storageItems
     *         Storage items.
     */
    void saveStorageItems(final List<StorageItem> storageItems);
}
