package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.Role;
import com.app.storage.persistence.model.RolePersistenceModel;

/**
 * Role persistence mapper.
 */
public interface RolePersistenceMapper {

    /**
     * Maps from {@link Role} to {@link RolePersistenceModel}
     *
     * @param role
     *         {@link Role}
     * @return {@link RolePersistenceModel}
     */
    RolePersistenceModel mapTo(Role role);

    /**
     * Maps from {@link RolePersistenceModel} to {@link Role}
     *
     * @param rolePersistenceModel
     *         {@link RolePersistenceModel}
     * @return {@link Role}
     */
    Role mapFrom(RolePersistenceModel rolePersistenceModel);
}
