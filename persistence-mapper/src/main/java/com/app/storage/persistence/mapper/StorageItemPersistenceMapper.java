package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.model.StorageItemPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;

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

    /**
     * Sets user persistence model to avoid circular dependency.
     *
     * @param userPersistenceModel
     *         {@link UserPersistenceModel}
     */
    void setUserPersistenceModel(final UserPersistenceModel userPersistenceModel);

    /**
     * Sets user model to avoid circular dependency.
     *
     * @param userModel
     *         {@link User}
     */
    void setUserModel(User userModel);
}
