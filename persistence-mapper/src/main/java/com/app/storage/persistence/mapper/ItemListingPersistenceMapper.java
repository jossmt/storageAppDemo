package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.persistence.model.ItemListingPersistenceModel;

/**
 * Storage item persistence mapper.
 */
public interface ItemListingPersistenceMapper {

    /**
     * Maps from {@link ItemListingPersistenceModel} to {@link ItemListing}
     *
     * @param itemListingPersistenceModel
     *         {@link ItemListingPersistenceModel}
     * @return {@link ItemListing}
     */
    ItemListing mapFrom(final ItemListingPersistenceModel itemListingPersistenceModel);

    /**
     * Maps from {@link ItemListing} to {@link ItemListingPersistenceModel}
     *
     * @param itemListing
     *         {@link ItemListing}
     * @return {@link ItemListingPersistenceModel}
     */
    ItemListingPersistenceModel mapTo(final ItemListing itemListing);
}
