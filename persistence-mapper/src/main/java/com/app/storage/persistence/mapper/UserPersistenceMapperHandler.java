package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link UserPersistenceMapper}
 */
@Component
public class UserPersistenceMapperHandler implements UserPersistenceMapper, AbstractMapper<UserPersistenceModel, User> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(UserPersistenceMapper.class);

    /** {@link RolePersistenceMapper} */
    @Autowired
    private RolePersistenceMapper rolePersistenceMapper;

    /** {@link ListMapper}. */
    private ListMapper listMapper;

    /**
     * Constructor
     */
    @Autowired
    public UserPersistenceMapperHandler(final ListMapper listMapper) {
        this.listMapper = listMapper;
    }

    /**
     * {@inheritDoc}
     */
    public UserPersistenceModel mapTo(final User user) {

        LOG.debug("Mapping user {} to persistence model.", user);

        UserPersistenceModel userPersistenceModel = null;
        if (user != null) {
            userPersistenceModel = new UserPersistenceModel();

            userPersistenceModel.setEmail(user.getEmail());
            userPersistenceModel.setFirstName(user.getFirstName());
            userPersistenceModel.setId(user.getId());
            userPersistenceModel.setLastName(user.getLastName());
            userPersistenceModel.setPassword(user.getPassword());
            userPersistenceModel.setRoles(listMapper.mapList((AbstractMapper) rolePersistenceMapper,
                                                             true, user.getRoles()));
        }

        LOG.debug("Successfully mapped user to persistence model: {}", userPersistenceModel);

        return userPersistenceModel;
    }

    /**
     * {@inheritDoc}
     */
    public User mapFrom(final UserPersistenceModel userPersistenceModel) {

        LOG.debug("Mapping user persistence model {} to domain model.", userPersistenceModel);

        User user = null;
        if (userPersistenceModel != null) {

            user = new User();
            user.setId(userPersistenceModel.getId());
            user.setEmail(userPersistenceModel.getEmail());
            user.setFirstName(userPersistenceModel.getFirstName());
            user.setLastName(userPersistenceModel.getLastName());
            user.setPassword(userPersistenceModel.getPassword());
            user.setRoles(listMapper.mapList((AbstractMapper) rolePersistenceMapper, false,
                                             userPersistenceModel.getRoles()));
        }

        LOG.debug("Successfully mapped persistence model to domain model: {}", user);

        return user;
    }
}
