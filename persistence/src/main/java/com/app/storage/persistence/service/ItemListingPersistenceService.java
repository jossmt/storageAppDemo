package com.app.storage.persistence.service;

import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.persistence.model.ItemListingPersistenceModel;

import java.util.List;

/**
 * Storage item persistence service.
 */
public interface ItemListingPersistenceService {

    /**
     * Retrieves all storage items.
     *
     * @return {@link ItemListingPersistenceModel}
     */
    List<ItemListing> retrieveAllStorageItems();

    /**
     * Saves all storage items in database.
     *
     * @param userEmail
     *         User email.
     * @param itemListing
     *         Storage item.
     */
    ItemListing saveStorageItem(String userEmail, ItemListing itemListing);

    /**
     * Returns storage item by unique reference code
     *
     * @param reference
     *         Unique reference.
     * @return {@link ItemListing}
     */
    ItemListing retrieveStorageItemByRef(String reference);
}
