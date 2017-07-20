package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.StorageItemPersistenceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link StorageItemPersistenceMapper}
 */
@Component
public class StorageItemPersistenceMapperHandler implements StorageItemPersistenceMapper,
        AbstractMapper<StorageItemPersistenceModel, StorageItem> {

    /** {@link ListMapper}. */
    private final ListMapper listMapper;

    /**
     * Constructor
     */
    @Autowired
    public StorageItemPersistenceMapperHandler(final ListMapper listMapper) {
        this.listMapper = listMapper;
    }

    /**
     * {@inheritDoc}
     */
    public StorageItem mapFrom(final StorageItemPersistenceModel storageItemPersistenceModel) {

        StorageItem storageItem = null;
        if (storageItemPersistenceModel != null) {

            storageItem = new StorageItem();
            storageItem.setName(storageItemPersistenceModel.getName());
            storageItem.setId(storageItemPersistenceModel.getId());
            storageItem.setDateStored(storageItemPersistenceModel.getDateStored());
            storageItem.setImage(storageItemPersistenceModel.getImage());
            storageItem.setSize(storageItemPersistenceModel.getSize());
        }

        return storageItem;
    }

    /**
     * {@inheritDoc}
     */
    public StorageItemPersistenceModel mapTo(final StorageItem storageItem) {

        StorageItemPersistenceModel storageItemPersistenceModel = null;
        if (storageItem != null) {

            storageItemPersistenceModel = new StorageItemPersistenceModel();
            storageItemPersistenceModel.setName(storageItem.getName());
            storageItemPersistenceModel.setSize(storageItem.getSize());
            storageItemPersistenceModel.setDateStored(storageItem.getDateStored());
            storageItemPersistenceModel.setImage(storageItem.getImage());

        }
        return storageItemPersistenceModel;
    }
}
