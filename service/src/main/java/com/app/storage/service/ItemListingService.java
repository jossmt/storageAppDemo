package com.app.storage.service;

import com.app.storage.domain.model.listing.ItemListing;

import java.util.List;
import java.util.Set;

/**
 * Storage item service.
 */
public interface ItemListingService {

    /**
     * Returns all storage items.
     *
     * @return ItemListing.
     */
    List<ItemListing> retrieveAllStorageItems();

    /**
     * Saves a list of storage items.
     *
     * @param userEmail
     *         User email.
     * @param itemListing
     *         Storage item list.
     */
    ItemListing saveStorageItem(String userEmail, ItemListing itemListing);

    /**
     * Returns storage item by unique reference.
     *
     * @param reference
     *         Unique reference.
     * @return {@link ItemListing}
     */
    ItemListing findStorageItemByReference(String reference);

    /**
     * Calculates total price of basket items.
     *
     * @param basketItems
     *         Items user added to basket.
     * @return
     */
    Double calculateTotalPrice(Set<ItemListing> basketItems);
}
