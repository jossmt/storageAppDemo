package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.persistence.model.StorageItemPersistenceModel;

/**
 * Storage item persistence mapper.
 */
public interface StorageItemPersistenceMapper {

    /**
     * Maps from {@link StorageItemPersistenceModel} to {@link StorageItem}
     *
     * @param storageItemPersistenceModel
     *         {@link StorageItemPersistenceModel}
     * @return {@link StorageItem}
     */
    StorageItem mapFrom(final StorageItemPersistenceModel storageItemPersistenceModel);

    /**
     * Maps from {@link StorageItem} to {@link StorageItemPersistenceModel}
     *
     * @param storageItem
     *         {@link StorageItem}
     * @return {@link StorageItemPersistenceModel}
     */
    StorageItemPersistenceModel mapTo(final StorageItem storageItem);
}
