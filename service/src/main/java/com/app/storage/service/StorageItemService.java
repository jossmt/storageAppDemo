package com.app.storage.service;

import com.app.storage.domain.model.StorageItem;

import java.util.List;

/**
 * Storage item service.
 */
public interface StorageItemService {

    /**
     * Returns all storage items.
     *
     * @return StorageItem.
     */
    List<StorageItem> retrieveAllStorageItems();

    /**
     * Saves a list of storage items.
     *
     * @param storageItems
     *         Storage item list.
     */
    void saveStorageItems(List<StorageItem> storageItems);
}
