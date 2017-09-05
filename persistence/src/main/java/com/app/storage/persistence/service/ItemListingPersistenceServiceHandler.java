package com.app.storage.persistence.service;

import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.persistence.mapper.ItemListingPersistenceMapper;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.ItemListingPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.repository.ItemListingRepository;
import com.app.storage.persistence.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * Implementation of {@link ItemListingPersistenceService}
 */
@Service
public class ItemListingPersistenceServiceHandler implements ItemListingPersistenceService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(ItemListingPersistenceService.class);

    /** {@link AbstractMapper} */
    private final ItemListingPersistenceMapper itemListingPersistenceMapper;

    /** {@link ItemListingRepository} */
    private final ItemListingRepository itemListingRepository;

    /** {@link UserRepository} */
    private final UserRepository userRepository;

    /** {@link ListMapper} */
    private final ListMapper listMapper;

    /**
     * Constructor.
     *
     * @param itemListingPersistenceMapper
     *         Storage item persistence mapper.
     */
    @Autowired
    public ItemListingPersistenceServiceHandler(final ItemListingPersistenceMapper itemListingPersistenceMapper,
                                                final ItemListingRepository itemListingRepository,
                                                final UserRepository userRepository,
                                                final ListMapper listMapper) {

        this.listMapper = listMapper;
        this.itemListingPersistenceMapper = itemListingPersistenceMapper;
        this.userRepository = userRepository;
        this.itemListingRepository = itemListingRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public List<ItemListing> retrieveAllStorageItems() {

        LOG.debug("Retrieving all storage items.");


        final List<ItemListingPersistenceModel> itemListingPersistenceModels = (List<ItemListingPersistenceModel>)
                itemListingRepository.findAll();

        final List<ItemListing> itemListings = listMapper.mapList((AbstractMapper) itemListingPersistenceMapper, false,
                                                                  itemListingPersistenceModels);


        LOG.debug("Successfully retrieved all storage items: {}", itemListings);

        return itemListings;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemListing saveStorageItem(final String userEmail, final ItemListing itemListing) {

        LOG.debug("Saving storage item to database: {}", itemListing);

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail(userEmail);

        final ItemListingPersistenceModel itemListingPersistenceModel = itemListingPersistenceMapper.mapTo
                (itemListing);

        itemListingPersistenceModel.setUserPersistenceModel(userPersistenceModel);

        final ItemListingPersistenceModel itemListingPersistenceModelSaved = itemListingRepository.save
                (itemListingPersistenceModel);

        final ItemListing itemListingSaved = itemListingPersistenceMapper.mapFrom(itemListingPersistenceModelSaved);

        LOG.debug("Saved storage items to database");

        return itemListingSaved;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ItemListing retrieveStorageItemByRef(final String reference) {

        LOG.debug("Fetching storage item by ref");

        final ItemListingPersistenceModel itemListingPersistenceModel = itemListingRepository.findByReference
                (reference);

        ItemListing itemListing;
        if (itemListingPersistenceModel != null) {

            itemListing = itemListingPersistenceMapper.mapFrom(itemListingPersistenceModel);
        } else {
            throw new NotFoundException("Unable to find storage item by reference given");
        }

        LOG.debug("Returning storage item");

        return itemListing;
    }


}
