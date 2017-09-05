package com.app.storage.controller.mapper;

import com.app.storage.controller.model.StorageItemControllerModel;
import com.app.storage.domain.model.listing.ItemListing;

/**
 * Mapper for {@link StorageItemControllerModel} {@link ItemListing}
 */
public interface StorageItemControllerMapper {

    /**
     * Map from {@link ItemListing} to {@link StorageItemControllerModel}
     *
     * @param itemListing
     *         {@link ItemListing}
     * @return {@link StorageItemControllerModel}
     */
    StorageItemControllerModel mapFrom(ItemListing itemListing);

    /**
     * Map from {@link StorageItemControllerModel} to {@link ItemListing}
     *
     * @param storageItemControllerModel
     *         {@link StorageItemControllerModel}
     * @return {@link ItemListing}
     */
    ItemListing mapTo(StorageItemControllerModel storageItemControllerModel);
}
