package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.model.StorageItemPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;

import java.util.List;

/**
 * User persistence mapper.
 */
public interface UserPersistenceMapper {

    /**
     * Maps from {@link User} to {@link UserPersistenceModel}
     *
     * @param user
     *         User domain model.
     * @return {@link UserPersistenceModel}
     */
    UserPersistenceModel mapTo(User user);

    /**
     * Maps from {@link UserPersistenceModel} to {@link User}
     *
     * @param userPersistenceModel
     *         User persistence model.
     * @return {@link User}
     */
    User mapFrom(UserPersistenceModel userPersistenceModel);
}
