package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.Grade;
import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.Base64ImageEncoder;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.StorageItemPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Implementation of {@link StorageItemPersistenceMapper}
 */
@Component
public class StorageItemPersistenceMapperHandler implements StorageItemPersistenceMapper,
        AbstractMapper<StorageItemPersistenceModel, StorageItem> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(StorageItemPersistenceMapper.class);

    /**
     * {@inheritDoc}
     */
    public StorageItem mapFrom(final StorageItemPersistenceModel storageItemPersistenceModel) {

        LOG.debug("Mapping storage item persistence model to domain model.");

        StorageItem storageItem = null;
        if (storageItemPersistenceModel != null) {

            storageItem = new StorageItem();
            storageItem.setReference(storageItemPersistenceModel.getReference());
            storageItem.setDescription(storageItemPersistenceModel.getDescription());
            storageItem.setDateStored(storageItemPersistenceModel.getDateStored());
            storageItem.setImage(storageItemPersistenceModel.getImage());
            storageItem.setImageUrl(Base64ImageEncoder.encodeImageUrl(storageItemPersistenceModel.getImage()));
            storageItem.setSize(storageItemPersistenceModel.getSize());
            storageItem.setBrand(storageItemPersistenceModel.getBrand());
            storageItem.setGrade(Grade.valueOf(storageItemPersistenceModel.getGrade()));
            storageItem.setPrice(storageItemPersistenceModel.getPrice());
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
            if(storageItem.getReference() != null){
                storageItemPersistenceModel.setReference(storageItem.getReference());
            }else{
                storageItemPersistenceModel.setReference(UUID.randomUUID().toString());
            }
            storageItemPersistenceModel.setDescription(storageItem.getDescription());
            storageItemPersistenceModel.setSize(storageItem.getSize());
            storageItemPersistenceModel.setDateStored(storageItem.getDateStored());
            storageItemPersistenceModel.setImage(storageItem.getImage());
            storageItemPersistenceModel.setBrand(storageItem.getBrand());
            storageItemPersistenceModel.setPrice(storageItem.getPrice());
            if (storageItem.getGrade() != null) {
                storageItemPersistenceModel.setGrade(storageItem.getGrade().name());
            }

        }

        LOG.debug("Mapping storage item persistence model to domain model.");

        return storageItemPersistenceModel;
    }
}
