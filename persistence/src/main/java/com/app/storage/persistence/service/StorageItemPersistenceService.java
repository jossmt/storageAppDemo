package com.app.storage.persistence.service;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.model.StorageItemPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;

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
     * @param userEmail
     *         User email.
     * @param storageItem
     *         Storage item.
     */
    StorageItem saveStorageItem(String userEmail, StorageItem storageItem);

    /**
     * Returns storage item by unique reference code
     *
     * @param reference
     *         Unique reference.
     * @return {@link StorageItem}
     */
    StorageItem retrieveStorageItemByRef(String reference);
}
