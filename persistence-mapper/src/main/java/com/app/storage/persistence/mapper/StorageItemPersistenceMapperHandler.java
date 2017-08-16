package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.Grade;
import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.StorageItemPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link StorageItemPersistenceMapper}
 */
@Component
public class StorageItemPersistenceMapperHandler implements StorageItemPersistenceMapper,
        AbstractMapper<StorageItemPersistenceModel, StorageItem> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(StorageItemPersistenceMapper.class);

    /** User persistence model. */
    private UserPersistenceModel userPersistenceModel;

    /** Sets user model. */
    private User user;

    /** {@link UserPersistenceMapper}. */
    private UserPersistenceMapper userPersistenceMapper;

    /**
     * {@inheritDoc}
     */
    public StorageItem mapFrom(final StorageItemPersistenceModel storageItemPersistenceModel) {

        LOG.debug("Mapping storage item persistence model to domain model.");

        StorageItem storageItem = null;
        if (storageItemPersistenceModel != null) {

            storageItem = new StorageItem();
            storageItem.setDescription(storageItemPersistenceModel.getDescription());
            storageItem.setDateStored(storageItemPersistenceModel.getDateStored());
            storageItem.setImage(storageItemPersistenceModel.getImage());
            storageItem.setSize(storageItemPersistenceModel.getSize());
            storageItem.setBrand(storageItemPersistenceModel.getBrand());
            storageItem.setGrade(Grade.valueOf(storageItemPersistenceModel.getGrade()));
            storageItem.setPrice(storageItemPersistenceModel.getPrice());

            if (user != null) {
                storageItem.setOwner(user);
            } else if (storageItemPersistenceModel.getUserPersistenceModel() != null) {
                storageItem.setOwner(userPersistenceMapper.mapFrom(storageItemPersistenceModel
                                                                           .getUserPersistenceModel()));
            }
        }

        LOG.debug("Mapping storage item domain model to persistence model.");


        return storageItem;
    }

    /**
     * {@inheritDoc}
     */
    public StorageItemPersistenceModel mapTo(final StorageItem storageItem) {

        LOG.debug("Mapping storage item domain model to persistence model.");

        StorageItemPersistenceModel storageItemPersistenceModel = null;
        if (storageItem != null) {
            storageItemPersistenceModel = new StorageItemPersistenceModel();
            storageItemPersistenceModel.setDescription(storageItem.getDescription());
            storageItemPersistenceModel.setSize(storageItem.getSize());
            storageItemPersistenceModel.setDateStored(storageItem.getDateStored());
            storageItemPersistenceModel.setImage(storageItem.getImage());
            storageItemPersistenceModel.setBrand(storageItem.getBrand());
            storageItemPersistenceModel.setPrice(storageItem.getPrice());
            if (storageItem.getGrade() != null) {
                storageItemPersistenceModel.setGrade(storageItem.getGrade().name());
            }

            if (userPersistenceModel != null) {
                storageItemPersistenceModel.setUserPersistenceModel(userPersistenceModel);
            } else if (storageItem.getOwner() != null) {
                storageItemPersistenceModel.setUserPersistenceModel(userPersistenceMapper.mapTo(storageItem.getOwner
                        ()));
            }

        }

        LOG.debug("Mapping storage item persistence model to domain model.");

        return storageItemPersistenceModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUserPersistenceModel(UserPersistenceModel userPersistenceModel) {
        this.userPersistenceModel = userPersistenceModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUserModel(User userModel) {
        this.user = userModel;
    }


    /**
     * Sets new {@link UserPersistenceMapper}..
     *
     * @param userPersistenceMapper
     *         New value of {@link UserPersistenceMapper}..
     */
    @Autowired
    public void setUserPersistenceMapper(final UserPersistenceMapper userPersistenceMapper) {
        this.userPersistenceMapper = userPersistenceMapper;
    }
}
