package com.app.storage.controller.mapper;

import com.app.storage.controller.model.StorageItemControllerModel;
import com.app.storage.domain.model.StorageItem;

import java.util.List;

/**
 * Mapper for {@link StorageItemControllerModel} {@link StorageItem}
 */
public interface StorageItemControllerMapper {

    /**
     * Map from {@link StorageItem} to {@link StorageItemControllerModel}
     *
     * @param storageItem
     *         {@link StorageItem}
     * @return {@link StorageItemControllerModel}
     */
    StorageItemControllerModel mapFrom(StorageItem storageItem);

    /**
     * Map from {@link StorageItemControllerModel} to {@link StorageItem}
     *
     * @param storageItemControllerModel
     *         {@link StorageItemControllerModel}
     * @return {@link StorageItem}
     */
    StorageItem mapTo(StorageItemControllerModel storageItemControllerModel);
}
