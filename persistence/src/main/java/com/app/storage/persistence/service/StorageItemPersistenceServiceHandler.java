package com.app.storage.persistence.service;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.persistence.mapper.StorageItemPersistenceMapper;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.StorageItemPersistenceModel;
import com.app.storage.persistence.repository.StorageItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link StorageItemPersistenceService}
 */
@Service
public class StorageItemPersistenceServiceHandler implements StorageItemPersistenceService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(StorageItemPersistenceService.class);

    /** {@link AbstractMapper} */
    private final StorageItemPersistenceMapper storageItemPersistenceMapper;

    /** {@link StorageItemRepository} */
    private final StorageItemRepository storageItemRepository;

    /** {@link ListMapper} */
    private final ListMapper listMapper;

    /**
     * Constructor.
     *
     * @param storageItemPersistenceMapper
     *         Storage item persistence mapper.
     */
    @Autowired
    public StorageItemPersistenceServiceHandler(final StorageItemPersistenceMapper storageItemPersistenceMapper,
                                                final StorageItemRepository storageItemRepository,
                                                final ListMapper listMapper) {

        this.listMapper = listMapper;
        this.storageItemPersistenceMapper = storageItemPersistenceMapper;
        this.storageItemRepository = storageItemRepository;
    }

    /**
     * {@inheritDoc}
     */
    public List<StorageItem> retrieveAllStorageItems() {

        LOG.debug("Retrieving all storage items.");


        final List<StorageItemPersistenceModel> storageItemPersistenceModels = (List<StorageItemPersistenceModel>)
                storageItemRepository.findAll();

        final List<StorageItem> storageItems = listMapper.mapList((AbstractMapper) storageItemPersistenceMapper, false,
                                                                  storageItemPersistenceModels);


        LOG.debug("Successfully retrieved all storage items: {}", storageItems);

        return storageItems;
    }

    /**
     * {@inheritDoc}
     */
    public void saveStorageItems(final List<StorageItem> storageItems) {

        LOG.debug("Saving storage items to database: {}", storageItems);

        final List<StorageItemPersistenceModel> storageItemPersistenceModels = listMapper.mapList
                ((AbstractMapper) storageItemPersistenceMapper, true, storageItems);

        storageItemRepository.save(storageItemPersistenceModels);

        LOG.debug("Saved storage items to database.");
    }


}
