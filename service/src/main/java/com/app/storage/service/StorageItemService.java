package com.app.storage.service;

import com.app.storage.domain.model.StorageItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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

    /**
     * Returns storage item by unique reference.
     *
     * @param reference
     *         Unique reference.
     * @return {@link StorageItem}
     */
    StorageItem findStorageItemByReference(String reference);

    /**
     * Calculates total price of basket items.
     *
     * @param basketItems
     *         Items user added to basket.
     * @return
     */
    Double calculateTotalPrice(Set<StorageItem> basketItems);
}
