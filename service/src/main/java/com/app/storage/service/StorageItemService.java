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
     * @param storageItem
     *         Storage item list.
     */
    void saveStorageItem(StorageItem storageItem);
}
