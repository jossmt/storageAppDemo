package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.User;
import com.app.storage.persistence.model.UserPersistenceModel;

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
