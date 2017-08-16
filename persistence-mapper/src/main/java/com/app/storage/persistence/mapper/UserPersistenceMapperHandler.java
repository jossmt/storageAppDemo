package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.StorageItemPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementation of {@link UserPersistenceMapper}
 */
@Component
public class UserPersistenceMapperHandler implements UserPersistenceMapper, AbstractMapper<UserPersistenceModel, User> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(UserPersistenceMapper.class);

    /** {@link StorageItemPersistenceModel}. */
    private List<StorageItemPersistenceModel> storageItemPersistenceModels;

    /** {@link StorageItem}. */
    private List<StorageItem> storageItems;

    /** {@link RolePersistenceMapper} */
    private RolePersistenceMapper rolePersistenceMapper;

    /** {@link StorageItemPersistenceMapper} */
    private StorageItemPersistenceMapper storageItemPersistenceMapper;

    /** {@link ListMapper}. */
    private ListMapper listMapper;

    /**
     * Constructor.
     *
     * @param listMapper
     *         {@link ListMapper}
     */
    @Autowired
    public UserPersistenceMapperHandler(final ListMapper listMapper) {
        this.listMapper = listMapper;
    }

    /**
     * {@inheritDoc}
     */
    public UserPersistenceModel mapTo(final User user) {

        LOG.debug("Mapping user to persistence model.");

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

            if (storageItemPersistenceModels != null) {
                userPersistenceModel.setStorageItemPersistenceModelList(storageItemPersistenceModels);
            } else if (user.getStorageItems() != null) {
                storageItemPersistenceMapper.setUserPersistenceModel(userPersistenceModel);
                userPersistenceModel
                        .setStorageItemPersistenceModelList(listMapper.mapList((AbstractMapper)
                                                                                       storageItemPersistenceMapper,
                                                                               true, user.getStorageItems()));
            }
        }

        LOG.debug("Successfully mapped user to persistence model");

        return userPersistenceModel;
    }

    /**
     * {@inheritDoc}
     */
    public User mapFrom(final UserPersistenceModel userPersistenceModel) {

        LOG.debug("Mapping user persistence model to domain model.");

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

            if (storageItems != null) {
                user.setStorageItems(storageItems);
            } else if (userPersistenceModel.getStorageItemPersistenceModelList() != null) {
                storageItemPersistenceMapper.setUserModel(user);
                user.setStorageItems(listMapper.mapList((AbstractMapper) storageItemPersistenceMapper, false,
                                                        userPersistenceModel.getStorageItemPersistenceModelList()));
            }
        }

        LOG.debug("Successfully mapped persistence model to domain model.");

        return user;
    }

    /**
     * Sets new {@link StorageItemPersistenceMapper}.
     *
     * @param storageItemPersistenceMapper
     *         New value of {@link StorageItemPersistenceMapper}.
     */
    @Autowired
    public void setStorageItemPersistenceMapper(StorageItemPersistenceMapper storageItemPersistenceMapper) {
        this.storageItemPersistenceMapper = storageItemPersistenceMapper;
    }

    /**
     * Sets new {@link RolePersistenceMapper}.
     *
     * @param rolePersistenceMapper
     *         New value of {@link RolePersistenceMapper}.
     */
    @Autowired
    public void setRolePersistenceMapper(RolePersistenceMapper rolePersistenceMapper) {
        this.rolePersistenceMapper = rolePersistenceMapper;
    }
}
