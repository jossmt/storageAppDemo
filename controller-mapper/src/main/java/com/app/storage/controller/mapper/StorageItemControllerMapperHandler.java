package com.app.storage.controller.mapper;

import com.app.storage.controller.model.StorageItemControllerModel;
import com.app.storage.domain.model.StorageItem;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Implementation of {@link StorageItemControllerMapper}
 */
@Component
public class StorageItemControllerMapperHandler implements StorageItemControllerMapper, AbstractMapper<StorageItem,
        StorageItemControllerModel> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(StorageItemControllerMapper.class);

    /**
     * {@inheritDoc}
     */
    public StorageItemControllerModel mapFrom(final StorageItem storageItem) {

        LOG.debug("Mapping storage item {} to storage item controller model.", storageItem);

        StorageItemControllerModel storageItemControllerModel = null;
        if (storageItem != null) {

            storageItemControllerModel = new StorageItemControllerModel();
            storageItemControllerModel.setName(storageItem.getName());
            storageItemControllerModel.setSize(storageItem.getSize());
            storageItemControllerModel.setImage(storageItem.getImage());
        }

        LOG.debug("Successfully mapped storage item to controller model {}.", storageItemControllerModel);

        return storageItemControllerModel;
    }

    /**
     * {@inheritDoc}
     */
    public StorageItem mapTo(final StorageItemControllerModel storageItemControllerModel) {

        LOG.debug("Mapping storage item controller model {} to domain model.", storageItemControllerModel);

        StorageItem storageItem = null;
        if (storageItemControllerModel != null) {

            storageItem = new StorageItem();
            storageItem.setName(storageItemControllerModel.getName());
            storageItem.setImage(storageItemControllerModel.getImage());
            storageItem.setSize(storageItemControllerModel.getSize());

        }

        LOG.debug("Mapped storage item controller model to domain model.", storageItem);

        return storageItem;
    }

}
