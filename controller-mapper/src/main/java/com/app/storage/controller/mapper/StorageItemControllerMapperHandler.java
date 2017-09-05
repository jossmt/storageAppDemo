package com.app.storage.controller.mapper;

import com.app.storage.controller.model.StorageItemControllerModel;
import com.app.storage.domain.model.Grade;
import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Implementation of {@link StorageItemControllerMapper}
 */
@Component
public class StorageItemControllerMapperHandler implements StorageItemControllerMapper, AbstractMapper<ItemListing,
        StorageItemControllerModel> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(StorageItemControllerMapper.class);

    /**
     * {@inheritDoc}
     */
    public StorageItemControllerModel mapFrom(final ItemListing itemListing) {

        LOG.debug("Mapping storage item {} to storage item controller model.", itemListing);

        StorageItemControllerModel storageItemControllerModel = null;
        if (itemListing != null) {

            storageItemControllerModel = new StorageItemControllerModel();
            storageItemControllerModel.setDescription(itemListing.getDescription());
            storageItemControllerModel.setSize(itemListing.getSize());
            storageItemControllerModel.setImage(itemListing.getImage());
            storageItemControllerModel.setBrand(itemListing.getBrand());
            if (itemListing.getGrade() != null) {
                storageItemControllerModel.setGrade(itemListing.getGrade().name());
            }
        }

        LOG.debug("Successfully mapped storage item to controller model {}.", storageItemControllerModel);

        return storageItemControllerModel;
    }

    /**
     * {@inheritDoc}
     */
    public ItemListing mapTo(final StorageItemControllerModel storageItemControllerModel) {

        LOG.debug("Mapping storage item controller model {} to domain model.", storageItemControllerModel);

        ItemListing itemListing = null;
        if (storageItemControllerModel != null) {

            itemListing = new ItemListing();
            itemListing.setDescription(storageItemControllerModel.getDescription());
            itemListing.setImage(storageItemControllerModel.getImage());
            itemListing.setSize(storageItemControllerModel.getSize());
            itemListing.setBrand(storageItemControllerModel.getBrand());
            itemListing.setGrade(Grade.getGrade(storageItemControllerModel.getGrade()));

        }

        LOG.debug("Mapped storage item controller model to domain model.", itemListing);

        return itemListing;
    }

}
